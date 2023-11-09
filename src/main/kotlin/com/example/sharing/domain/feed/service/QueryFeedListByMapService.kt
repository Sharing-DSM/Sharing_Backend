package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryFeedListByMapService(
    private val feedRepository: FeedRepository,
) {
    @Transactional(readOnly = true)
    fun execute(location: String): List<FeedElement> {
        return feedRepository.findAllByAddressNameContaining(location)
    }
}