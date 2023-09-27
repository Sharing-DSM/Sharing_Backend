package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.domain.User
import com.example.sharing.domain.user.domain.repository.UserRepository
import com.example.sharing.domain.user.presentation.dto.request.UserSignUpRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Transactional
@Service
class UserSignUpService(
    private val userRepository: UserRepository,
) {

    fun signUp(userSignUpRequest: UserSignUpRequest): String {
        var user: User? = userRepository
            .findByAccountId(userSignUpRequest.accountId)
        if (user != null) {
            return "이미 있는 id"
        }

        user = User(
            userSignUpRequest.id,
            userSignUpRequest.accountId,
            userSignUpRequest.password,
            userSignUpRequest.name,
            userSignUpRequest.age,
            userSignUpRequest.profile
        )

        userRepository.save(user)

        return "회원가입 완료"
    }
}