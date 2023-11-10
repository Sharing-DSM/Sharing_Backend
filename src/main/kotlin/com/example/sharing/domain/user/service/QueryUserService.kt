package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.domain.repository.UserRepository
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.domain.user.presentation.dto.response.QueryUserResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryUserService(
    private val userFacade: UserFacade,
    private val userRepository: UserRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): QueryUserResponse {
        val user = userFacade.getCurrentUser()
        return QueryUserResponse(user.name, user.accountId, user.age)
    }
}