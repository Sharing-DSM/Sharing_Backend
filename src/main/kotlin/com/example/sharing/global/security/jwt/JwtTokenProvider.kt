package com.example.sharing.global.security.jwt

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.user.domain.RefreshToken
import com.example.sharing.domain.user.domain.repository.RefreshTokenRepository
import com.example.sharing.domain.user.presentation.dto.response.TokenResponse
import com.example.sharing.global.exception.TokenExpiredExcpetion
import com.example.sharing.global.exception.TokenInvalidException
import com.example.sharing.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import org.springframework.util.StringUtils
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    fun getToken(accountId: String): TokenResponse {
        val accessToken: String = generateAccessToken(accountId)
        val refreshToken: String = generateRefreshToken(accountId)

        return TokenResponse(accessToken = accessToken, refreshToken = refreshToken)
    }

    fun generateAccessToken(accountId: String): String {
        return createToken(accountId, "access", jwtProperties.accessExp)
    }

    fun generateRefreshToken(accountId: String): String {
        val refreshToken = createToken(accountId, "refresh", jwtProperties.refreshExp)

        refreshTokenRepository.save(
            RefreshToken(
                accountId = accountId,
                token = refreshToken
            )
        )

        return refreshToken
    }

    private fun createToken(accountId: String, typ: String, exp: Long): String {
        return jwtProperties.prefix + Jwts.builder()
            .setSubject(accountId)
            .claim("typ", typ)
            .signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setExpiration(Date(System.currentTimeMillis() + exp * 1000))
            .setIssuedAt(Date())
            .compact()
    }

    fun getAuthentication(token: String): UsernamePasswordAuthenticationToken {
        val userDetails: UserDetails = authDetailsService.loadUserByUsername(getAccountId(token))
        return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
    }

    private fun getAccountId(token: String): String {
        return getClaims(token).subject
    }

    private fun getClaims(token: String): Claims {
        return try {
            Jwts.parser()
                .setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token)
                .body
        } catch (e: ExpiredJwtException) {
            throw TokenExpiredExcpetion.EXCPETION
        } catch (e: Exception) {
            e.printStackTrace()
            throw TokenInvalidException.EXCEPTION
    }
}

fun resolveToken(request: HttpServletRequest): String? {
    val bearerToken = request.getHeader(jwtProperties.header)

    return if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.prefix)
        && bearerToken.length > jwtProperties.prefix.length + 1
    ) {
        bearerToken.substring(jwtProperties.prefix.length)
    } else null
}

fun resolveToken(socketIOClient: SocketIOClient): String? {
    val bearerToken = socketIOClient.handshakeData.httpHeaders[jwtProperties.header]

    if (StringUtils.hasText(bearerToken) && bearerToken.startsWith(jwtProperties.prefix)
        && bearerToken.length > jwtProperties.prefix.length + 1
    ) {
        return bearerToken.substring(jwtProperties.prefix.length)
    } else return null
}
}