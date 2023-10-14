package com.example.sharing.domain.feed.presentation

import com.example.sharing.domain.feed.presentation.dto.request.FeedUpdateRequest
import com.example.sharing.domain.feed.service.FeedUpdateService
import org.springframework.http.ResponseEntity
import org.springframework.web.bind.annotation.*
import java.util.UUID
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val feedUpdateService: FeedUpdateService,
) {

    // feed 수정
    @PutMapping("/{id}")
    fun updateFeed(@PathVariable id: UUID, @RequestBody @Valid request: FeedUpdateRequest): ResponseEntity<Any> {
        val feed = feedUpdateService.execute(id, request)
        return ResponseEntity.ok().body(feed)
    }
}