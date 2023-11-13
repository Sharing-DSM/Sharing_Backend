package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.ApplyRepository
import com.example.sharing.domain.feed.presentation.dto.response.ApplyElement
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyApplyFeedListService(
    val userFacade: UserFacade,
    val applyRepository: ApplyRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): List<ApplyElement> {
        val user = userFacade.getCurrentUser()
        return applyRepository.findAllByUserOrderByAppliedAtDesc(user)
    }
}
