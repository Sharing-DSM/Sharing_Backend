package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SetInterestAreaService(
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(interestArea: String) {
        val user = userFacade.getCurrentUser()
        user.updateInterestArea(interestArea)
    }
}