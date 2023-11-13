package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.request.QueryFeedByMapRequest
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import com.example.sharing.global.utils.openfeign.client.KakaoAddressFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import kotlin.streams.toList

@Service
class QueryFeedListByMapService(
    private val feedRepository: FeedRepository,
    private val kakaoAddressFeign: KakaoAddressFeign,
) {
    @Transactional(readOnly = true)
    fun execute(request: QueryFeedByMapRequest): List<FeedElement> {
        val location = kakaoAddressFeign.queryAddressByXAndY(request.x, request.y).documents.stream().map { it.address.region1depthName }.toList()
        return location.flatMap { feedRepository.findAllByAddressNameContaining(it) }
    }
}