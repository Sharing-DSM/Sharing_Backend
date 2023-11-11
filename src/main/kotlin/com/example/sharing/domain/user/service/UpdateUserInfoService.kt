package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.domain.user.presentation.dto.request.UpdateUserInfoRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class UpdateUserInfoService(
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(request: UpdateUserInfoRequest) {
        val user = userFacade.getCurrentUser()
        user.updateUserInfo(request.accountId, request.name, request.age)
    }

}