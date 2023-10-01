package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.domain.repository.UserRepository
import com.example.sharing.domain.user.exception.PasswordMisMatchedException
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.domain.user.presentation.dto.request.UserLoginRequest
import com.example.sharing.domain.user.presentation.dto.response.TokenResponse
import com.example.sharing.global.security.jwt.JwtTokenProvider
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UserLoginService(
    val userFacade: UserFacade,
    val passwordEncoder: PasswordEncoder,
    val tokenProvider: JwtTokenProvider
) {
    @Transactional
    fun execute(request: UserLoginRequest) : TokenResponse {
        val user = userFacade.getByAccountId(request.accountId)
        if (!passwordEncoder.matches(request.password, user.password)){
            throw PasswordMisMatchedException.EXCEPTION
        }

        return tokenProvider.getToken(user.accountId)
    }
}