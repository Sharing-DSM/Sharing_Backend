package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.response.QueryFeedDetailResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class SearchTitleFeedService(
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {
    @Transactional(readOnly = true)
    fun execute(keyword: String): QueryFeedDetailResponse {
        val feed = feedRepository.findByTitleContaining(keyword)

        return QueryFeedDetailResponse(
            feedId = feed.id,
            title = feed.title,
            recruitment = feed.recruitment,
            addressName = feed.addressName,
            roadAddressName = feed.roadAddressName,
            x = feed.x,
            y = feed.y,
            type = feed.type,
            volunteerTime = feed.volunteerTime,
            content = feed.content,
            isEmergency = feed.isEmergency,
            userId = feed.user.id,
            userProfile = feed.user.profile,
            isMine = getIsMine(feed.user.id)
        )
    }

    private fun getIsMine(userId: UUID): Boolean {
        return userId == userFacade.getUserId()
    }
}