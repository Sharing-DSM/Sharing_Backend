package com.example.sharing.domain.feed.presentation

import com.example.sharing.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.sharing.domain.feed.presentation.dto.request.CreateTagRequest
import com.example.sharing.domain.feed.presentation.dto.request.QueryAddressRequest
import com.example.sharing.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.sharing.domain.feed.presentation.dto.response.QueryAddressResponse
import com.example.sharing.domain.feed.service.CreateFeedService
import com.example.sharing.domain.feed.service.CreateTagService
import com.example.sharing.domain.feed.service.SearchAddressService
import com.example.sharing.domain.feed.service.UpdateFeedService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.UUID
import javax.validation.Valid


@RequestMapping("/feeds")
@RestController
class FeedController(
  private val updateFeedService: UpdateFeedService,
  private val createFeedService: CreateFeedService,
  private val searchAddressService: SearchAddressService,
) {
    
    @ResponseStatus(CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }
    
    @ResponseStatus(HttpStatus.NO_CONTENT)
    @PatchMapping("/{feed-id}")
    fun updateFeed(@PathVariable ("feed-id") feedId: UUID, @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }
    
    @GetMapping("/address")
    fun getAddress(@RequestBody request: QueryAddressRequest): QueryAddressResponse {
        return searchAddressService.execute(request)
    }
}