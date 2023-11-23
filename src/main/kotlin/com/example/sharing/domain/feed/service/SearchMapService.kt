package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.repository.FeedRepository
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.global.utils.openfeign.client.KakaoAddressFeign
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchMapService(
    private val kakaoAddressFeign: KakaoAddressFeign,
    private val feedRepository: FeedRepository,
    private val userFacade: UserFacade,
) {
    @Transactional(readOnly = true)
    fun execute(keyword: String): List<FeedElement> {
        val x = kakaoAddressFeign.queryAddress(keyword,1,1).documents.get(1).x
        val y = kakaoAddressFeign.queryAddress(keyword,1,1).documents.get(1).y
        val address = kakaoAddressFeign.queryAddressByXAndY(x as Double, y as Double).documents.get(1).address.region1depthName
        return feedRepository.findAllByAddressNameContaining(address)
    }
}