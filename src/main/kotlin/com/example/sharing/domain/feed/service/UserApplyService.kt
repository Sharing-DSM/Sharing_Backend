package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.domain.ApplyId
import com.example.sharing.domain.feed.domain.repository.ApplyRepository
import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.exception.FeedNotFoundException
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.lang.Boolean.TRUE
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

        val applyId = ApplyId(user.id, feed.id)
        val apply = Apply(applyId, user, feed)

        applyRepository.save(apply)
    }
}