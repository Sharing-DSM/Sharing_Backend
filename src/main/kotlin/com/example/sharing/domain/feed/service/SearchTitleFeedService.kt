package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import com.example.sharing.domain.feed.presentation.dto.response.QueryFeedDetailResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class SearchTitleFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {
    @Transactional(readOnly = true)
    fun execute(keyword: String): List<FeedElement> {
        return feedRepository.findByTitleContaining(keyword)
    }
}