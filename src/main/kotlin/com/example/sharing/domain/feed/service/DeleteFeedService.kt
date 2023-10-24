package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
class DeleteFeedService(
    private val feedRepository: FeedRepository,
) {
    @Transactional
    fun execute(id: UUID) {

        val feed = feedRepository.findById(id)

        if (feed != null) {
            feedRepository.deleteById(id)
        } else {
            throw IllegalArgumentException("Feed not found for ID: $id")
        }

    }
}