package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.exception.FeedNotFoundException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Boolean.TRUE
import java.util.*

@Service
class UserApplyService(
    val feedRepository: FeedRepository,
) {
    @Transactional
    fun execute(feedId: UUID) {
        val feed = feedRepository.findById(feedId)
            .orElseThrow { FeedNotFoundException.EXCEPTION }

        feed.apply = TRUE
    }
}