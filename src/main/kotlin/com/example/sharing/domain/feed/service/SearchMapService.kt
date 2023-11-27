package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.request.SearchFeedByMapRequest
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import com.example.sharing.global.utils.openfeign.client.KakaoAddressFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchMapService(
    private val kakaoAddressFeign: KakaoAddressFeign,
    private val feedRepository: FeedRepository,
) {
    @Transactional(readOnly = true)
    fun execute(request: SearchFeedByMapRequest): List<FeedElement> {
        val location = kakaoAddressFeign.queryAddressByXAndY(request.x, request.y).documents[0].address.region1depthName
        return if (request.keyword == "") {
            feedRepository.findAllByAddressNameContaining(location)
        } else {
            feedRepository.findAllByTitleContainingAndAddressNameContaining(request.keyword, location)
        }
    }
}