package com.example.sharing.domain.feed.facade

import com.example.sharing.domain.feed.domain.Feed
import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.exception.FeedNotFoundException
import org.springframework.stereotype.Component
import java.util.*

@Component
class FeedFacade(
    private val feedRepository: FeedRepository
) {
    fun getByFeedId(feedId: UUID): Feed {
        return feedRepository.findById(feedId).orElseThrow { FeedNotFoundException.EXCEPTION }
    }
}