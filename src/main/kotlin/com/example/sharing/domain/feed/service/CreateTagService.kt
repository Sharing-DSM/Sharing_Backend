package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Tag
import com.example.sharing.domain.feed.domain.repository.TagRepository
import com.example.sharing.domain.feed.facade.FeedFacade
import com.example.sharing.domain.feed.presentation.dto.request.CreateTagRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CreateTagService(
    private val feedFacade: FeedFacade,
    private val tagRepository: TagRepository
) {
    @Transactional
    fun execute(feedId: UUID, request: CreateTagRequest) {
        val feed = feedFacade.getByFeedId(feedId)

        tagRepository.save(
            Tag(
                id = UUID.randomUUID(),
                name = request.name,
                feed = feed
            )
        )
    }
}