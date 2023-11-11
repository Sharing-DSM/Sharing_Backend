package com.example.sharing.global.security.jwt

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.user.domain.RefreshToken
import com.example.sharing.domain.user.domain.repository.RefreshTokenRepository
import com.example.sharing.domain.user.presentation.dto.response.TokenResponse
import com.example.sharing.global.exception.InternalServerError
import com.example.sharing.global.exception.TokenExpiredExcpetion
import com.example.sharing.global.exception.TokenInvalidException
import com.example.sharing.global.security.auth.AuthDetailsService
import io.jsonwebtoken.Claims
import io.jsonwebtoken.ExpiredJwtException
import io.jsonwebtoken.InvalidClaimException
import io.jsonwebtoken.Jwts
import io.jsonwebtoken.SignatureAlgorithm
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.stereotype.Component
import java.util.*
import javax.servlet.http.HttpServletRequest

@Component
class JwtTokenProvider(
    private val jwtProperties: JwtProperties,
    private val authDetailsService: AuthDetailsService,
    private val refreshTokenRepository: RefreshTokenRepository
) {
    fun getToken(accountId: String): TokenResponse {
        val accessToken: String = generateToken(accountId, jwtProperties.accessExp)
        val refreshToken: String = generateRefreshToken(accountId)

        return TokenResponse(accessToken = accessToken, refreshToken = refreshToken)
    }

    fun generateRefreshToken(accountId: String): String {
        val newRefreshToken: String = generateToken(accountId, jwtProperties.refreshExp)
        refreshTokenRepository.save(
            RefreshToken(
                accountId = (accountId),
                token = newRefreshToken
            )
        )
        return newRefreshToken
    }

    private fun generateToken(accountId: String, expiration: Long): String {
        return jwtProperties.prefix + Jwts.builder().signWith(SignatureAlgorithm.HS256, jwtProperties.secretKey)
            .setSubject(accountId)
            .setHeaderParam("typ", "access")
            .setIssuedAt(Date())
            .setExpiration(Date(System.currentTimeMillis() + expiration * 1000))
            .compact()
    }

    fun resolveToken(request: HttpServletRequest): String? {
        val bearer: String? = request.getHeader(jwtProperties.header)
        return parseToken(bearer)
    }

    fun parseToken(bearerToken: String?): String? {
        return if (bearerToken != null && bearerToken.startsWith(jwtProperties.prefix)) {
            bearerToken.replace(jwtProperties.prefix, "")
        } else null
    }

    fun authorization(token: String): UsernamePasswordAuthenticationToken {
        return token.let {
            val userDetails: UserDetails = authDetailsService.loadUserByUsername(getTokenSubject(token))
            return UsernamePasswordAuthenticationToken(userDetails, "", userDetails.authorities)
        }
    }

    fun resolveToken(socketIOClient: SocketIOClient): String? {
        val bearer = socketIOClient.handshakeData.httpHeaders.get(jwtProperties.header)
        return if (bearer != null && bearer.startsWith(jwtProperties.prefix)) {
            bearer.replace(jwtProperties.prefix, "")
        } else {
            null
        }
    }

    private fun getTokenSubject(subject: String): String {
        return getTokenBody(subject).subject
    }

    private fun getTokenBody(token: String?): Claims {
        return try {
            Jwts.parser().setSigningKey(jwtProperties.secretKey)
                .parseClaimsJws(token).body
        } catch (e: Exception) {
            when (e) {
                is ExpiredJwtException -> throw TokenExpiredExcpetion.EXCPETION
                is InvalidClaimException -> throw TokenInvalidException.EXCEPTION
                else -> throw InternalServerError.EXCEPTION
            }
        }
    }
}