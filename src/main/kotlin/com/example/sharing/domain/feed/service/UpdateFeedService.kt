package com.example.sharing.domain.feed.service

import com.example.sharing.domain.chat.exception.InvalidUserException
import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.exception.FeedNotFoundException
import com.example.sharing.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.sharing.domain.user.domain.User
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*


@Service
class UpdateFeedService(
    val feedRepository: FeedRepository,
    val userFacade: UserFacade
) {
    @Transactional
    fun execute(feedId: UUID, request: UpdateFeedRequest) {
        val user: User = userFacade.getCurrentUser()
        val feed = feedRepository.findById(feedId)
            .orElseThrow { FeedNotFoundException.EXCEPTION }
        if (user.id != feed.user.id) {
            throw InvalidUserException.EXCEPTION
        }
        feed.updateFeed(
            request.title,
            request.content,
            request.recruitment,
            request.volunteerTime,
            request.addressName,
            request.isEmergency,
            request.roadAddressName,
            request.x,
            request.y,
            request.type
        )
    }
}