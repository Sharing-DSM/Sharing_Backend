package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Feed
import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.request.FeedUpdateRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.UUID

@Service
class FeedUpdateService(
    val feedRepository: FeedRepository
) {
    @Transactional
    fun execute(id: UUID, request: FeedUpdateRequest): Feed {
        val feed = feedRepository.findById(id).get()
        feed.updateFeed(request)
        return feed
    }
}