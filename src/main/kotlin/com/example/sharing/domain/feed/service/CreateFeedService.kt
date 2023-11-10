package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Feed
import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CreateFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(request: CreateFeedRequest) {
        val user = userFacade.getCurrentUser()

        feedRepository.save(
            Feed(
                id = UUID.randomUUID(),
                title = request.title,
                content = request.content,
                addressName = request.addressName,
                roadAddressName = request.roadAddressName,
                x = request.x,
                y = request.y,
                recruitment = request.recruitment,
                volunteerTime = request.volunteerTime,
                views = 0,
                isEmergency = request.isEmergency,
                type = request.type,
                user = user
            )
        )
    }
}