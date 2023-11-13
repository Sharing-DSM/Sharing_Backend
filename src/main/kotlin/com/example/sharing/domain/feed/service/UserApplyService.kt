package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.domain.repository.ApplyRepository
import com.example.sharing.domain.feed.facade.FeedFacade
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class UserApplyService(
    val applyRepository: ApplyRepository,
    val feedFacade: FeedFacade,
    val userFacade: UserFacade,
) {
    @Transactional
    fun execute(feedId: UUID) {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getByFeedId(feedId)

        applyRepository.save(Apply(UUID.randomUUID(), user, feed, LocalDateTime.now()))
    }
}