package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import com.example.sharing.domain.user.exception.UserInterestAreaNotFoundException
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedByInterestAreaService(
    private val userFacade: UserFacade,
    private val feedRepository: FeedRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): List<FeedElement> {
        val user = userFacade.getCurrentUser()
        return feedRepository.findAllByAddressNameContaining(user.interestArea?: throw UserInterestAreaNotFoundException.EXCEPTION)
    }
}