package com.example.sharing.domain.feed.presentation

import com.example.sharing.domain.feed.presentation.dto.request.CreateFeedRequest
import com.example.sharing.domain.feed.presentation.dto.request.QueryAddressRequest
import com.example.sharing.domain.feed.presentation.dto.request.QueryFeedByMapRequest
import com.example.sharing.domain.feed.presentation.dto.request.SearchFeedByMapRequest
import com.example.sharing.domain.feed.presentation.dto.request.UpdateFeedRequest
import com.example.sharing.domain.feed.presentation.dto.response.ApplicantElement
import com.example.sharing.domain.feed.presentation.dto.response.ApplyElement
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import com.example.sharing.domain.feed.presentation.dto.response.QueryAddressResponse
import com.example.sharing.domain.feed.presentation.dto.response.QueryFeedDetailResponse
import com.example.sharing.domain.feed.service.CreateFeedService
import com.example.sharing.domain.feed.service.DeleteFeedService
import com.example.sharing.domain.feed.service.QueryApplicantService
import com.example.sharing.domain.feed.service.QueryEmergencyFeedService
import com.example.sharing.domain.feed.service.QueryFeedByInterestAreaService
import com.example.sharing.domain.feed.service.QueryFeedByViewsService
import com.example.sharing.domain.feed.service.QueryFeedDetailService
import com.example.sharing.domain.feed.service.QueryFeedListByMapService
import com.example.sharing.domain.feed.service.QueryMyApplyFeedListService
import com.example.sharing.domain.feed.service.QueryMyFeedListService
import com.example.sharing.domain.feed.service.SearchAddressService
import com.example.sharing.domain.feed.service.SearchMapService
import com.example.sharing.domain.feed.service.SearchTitleFeedService
import com.example.sharing.domain.feed.service.UpdateFeedService
import com.example.sharing.domain.feed.service.UserApplyService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.DeleteMapping
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PatchMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RequestMapping("/feeds")
@RestController
class FeedController(
    private val updateFeedService: UpdateFeedService,
    private val createFeedService: CreateFeedService,
    private val deleteFeedService: DeleteFeedService,
    private val searchAddressService: SearchAddressService,
    private val userApplyService: UserApplyService,
    private val queryFeedDetailService: QueryFeedDetailService,
    private val queryFeedByViewsService: QueryFeedByViewsService,
    private val queryFeedByInterestAreaService: QueryFeedByInterestAreaService,
    private val queryFeedListByMapService: QueryFeedListByMapService,
    private val queryMyFeedListService: QueryMyFeedListService,
    private val queryMyApplyFeedListService: QueryMyApplyFeedListService,
    private val queryEmergencyFeedService: QueryEmergencyFeedService,
    private val searchTitleFeedService: SearchTitleFeedService,
    private val queryApplicantService: QueryApplicantService,
    private val searchMapService: SearchMapService,
) {

    @ResponseStatus(CREATED)
    @PostMapping
    fun createFeed(@RequestBody @Valid request: CreateFeedRequest) {
        createFeedService.execute(request)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{feed-id}")
    fun deleteFeed(@PathVariable("feed-id") id: UUID) {
        deleteFeedService.execute(id)
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/{feed-id}")
    fun updateFeed(@PathVariable("feed-id") feedId: UUID, @RequestBody @Valid request: UpdateFeedRequest) {
        updateFeedService.execute(feedId, request)
    }

    @ResponseStatus(CREATED)
    @PostMapping("/apply/{feed-id}")
    fun apply(@PathVariable("feed-id") feedId: UUID) {
        userApplyService.execute(feedId)
    }

    @PostMapping("/address")
    fun getAddress(@RequestBody request: QueryAddressRequest): QueryAddressResponse {
        return searchAddressService.execute(request)
    }

    @GetMapping("/{feed-id}")
    fun getFeedDetail(@PathVariable("feed-id") feedId: UUID): QueryFeedDetailResponse {
        return queryFeedDetailService.execute(feedId)
    }

    @GetMapping
    fun getFeedListByViews(): List<FeedElement> {
        return queryFeedByViewsService.execute()
    }

    @GetMapping("/interest-area")
    fun getFeedListByInterestArea(): List<FeedElement> {
        return queryFeedByInterestAreaService.execute()
    }

    @PostMapping("/map")
    fun getFeedListByMap(@RequestBody @Valid request: QueryFeedByMapRequest): List<FeedElement> {
        return queryFeedListByMapService.execute(request)
    }

    @GetMapping("/mine")
    fun getMyFeedList(): List<FeedElement> {
        return queryMyFeedListService.execute()
    }

    @GetMapping("/apply")
    fun getMyApplyFeed(): List<ApplyElement> {
        return queryMyApplyFeedListService.execute()
    }

    @GetMapping("/emergency")
    fun getEmergencyFeed(): List<FeedElement> {
        return queryEmergencyFeedService.execute()
    }

    @GetMapping("/search")
    fun getSearchTitle(@RequestParam("keyword") keyword: String): List<FeedElement> {
        return searchTitleFeedService.execute(keyword)
    }

    @GetMapping("/applicant/{feed-id}")
    fun getApplicant(@PathVariable("feed-id") feedId: UUID): List<ApplicantElement> {
        return queryApplicantService.execute(feedId)
    }

    @PostMapping("/search/map")
    fun getSearchMap(@RequestBody @Valid request: SearchFeedByMapRequest): List<FeedElement> {
        return searchMapService.execute(request)
    }
}
