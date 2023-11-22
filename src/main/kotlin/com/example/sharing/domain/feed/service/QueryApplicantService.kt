package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.ApplyRepository
import com.example.sharing.domain.feed.facade.FeedFacade
import com.example.sharing.domain.feed.presentation.dto.response.ApplicantElement
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QueryApplicantService(
    private val applyRepository: ApplyRepository,
    private val feedFacade: FeedFacade,
) {
    @Transactional(readOnly = true)
    fun execute(feedId: UUID): List<ApplicantElement> {
        val feed = feedFacade.getByFeedId(feedId)
        return applyRepository.findAllByFeed(feed)
    }
}