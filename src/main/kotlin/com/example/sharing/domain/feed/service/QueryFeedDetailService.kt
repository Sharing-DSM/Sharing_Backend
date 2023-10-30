package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.facade.FeedFacade
import com.example.sharing.domain.feed.presentation.dto.response.QueryFeedDetailResponse
import com.example.sharing.domain.user.exception.UserNotFoundException
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QueryFeedDetailService(
    private val feedFacade: FeedFacade,
    private val userFacade: UserFacade,
) {
    @Transactional(readOnly = true)
    fun execute(feedId: UUID): QueryFeedDetailResponse {
        val feed = feedFacade.getByFeedId(feedId)

        return QueryFeedDetailResponse(
            feedId = feed.id,
            title = feed.title,
            recruitment = feed.recruitment,
            addressName = feed.addressName,
            volunteerTime = feed.volunteerTime,
            content = feed.content,
            isMine = getIsMine(feed.user.id)
        )
    }

    private fun getIsMine(userId: UUID): Boolean {
        return try {
            userId == userFacade.getUserId()
        } catch(e: UserNotFoundException) {
            false
        }
    }
}