package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.domain.repository.ApplyRepository
import com.example.sharing.domain.feed.exception.AlreadyApplyException
import com.example.sharing.domain.feed.facade.FeedFacade
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.global.utils.firebase.notification.FcmService
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class UserApplyService(
    val applyRepository: ApplyRepository,
    val feedFacade: FeedFacade,
    val userFacade: UserFacade,
    val fcmService: FcmService,
) {
    @Transactional
    fun execute(feedId: UUID) {
        val user = userFacade.getCurrentUser()
        val feed = feedFacade.getByFeedId(feedId)

        if(applyRepository.existsByUserAndFeed(user, feed)) {
            throw AlreadyApplyException.EXCEPTION
        }

        applyRepository.save(Apply(UUID.randomUUID(), user, feed, LocalDateTime.now()))

        fcmService.sendMessage(feed.user.deviceToken, "봉사 신청", "\'${feed.title}\'에 신청이 들어왔습니다.")
    }
}