package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.domain.User
import com.example.sharing.domain.user.domain.repository.UserRepository
import com.example.sharing.domain.user.exception.AlreadyUserAccountIdExistsException
import com.example.sharing.domain.user.presentation.dto.request.UserSignUpRequest
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.security.crypto.password.PasswordEncoder
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserSignUpService(
    private val userRepository: UserRepository,
    private val passwordEncoder: PasswordEncoder
) {
    @Transactional
    fun excute(request: UserSignUpRequest) {
        if (userRepository.existsByAccountId(request.accountId)) {
            throw AlreadyUserAccountIdExistsException.EXCEPTION
        }

        userRepository.save(
            User(
                id = UUID.randomUUID(),
                accountId = request.accountId,
                password = passwordEncoder.encode(request.password),
                name = request.name,
                age = request.age,
                profile = null
            )
        )
    }
}