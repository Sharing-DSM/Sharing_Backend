package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.domain.ApplyId
import com.example.sharing.domain.feed.domain.Feed
import com.example.sharing.domain.feed.domain.repository.ApplyRepository
import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.exception.FeedNotFoundException
import com.example.sharing.domain.user.domain.User
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UserApplyService(
    val applyRepository: ApplyRepository,
    val feedRepository: FeedRepository,
    val userFacade: UserFacade,
) {
    @Transactional
    fun execute(feedId: UUID) {
        val user = userFacade.getCurrentUser()
        val feed = feedRepository.findById(feedId)
            .orElseThrow { FeedNotFoundException.EXCEPTION }

        val apply = createApply(user, feed)

        applyRepository.save(apply)
    }

    fun createApply(user: User, feed: Feed): Apply {
        val applyId = ApplyId(user.id, feed.id)
        return Apply(applyId, user, feed)
    }
}