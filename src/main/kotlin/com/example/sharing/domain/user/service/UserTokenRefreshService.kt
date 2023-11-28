package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.domain.repository.RefreshTokenRepository
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.domain.user.presentation.dto.response.TokenResponse
import com.example.sharing.global.security.jwt.JwtTokenProvider
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserTokenRefreshService(
    private val refreshTokenRepository: RefreshTokenRepository,
    private val userFacade: UserFacade,
    private val jwtTokenProvider: JwtTokenProvider,
) {
    @Transactional
    fun execute(refreshToken: String): TokenResponse {
        val user = userFacade.getCurrentUser()
        val token = refreshTokenRepository.findByToken(refreshToken)
        val tokenResponse = jwtTokenProvider.getToken(user.accountId)
        token.updateToken(tokenResponse.refreshToken)
        return TokenResponse(tokenResponse.accessToken, tokenResponse.refreshToken)
    }
}