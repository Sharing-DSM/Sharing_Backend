package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.presentation.dto.request.QueryAddressRequest
import com.example.sharing.domain.feed.presentation.dto.response.QueryAddressResponse
import com.example.sharing.domain.feed.presentation.dto.response.QueryAddressResponse.*
import com.example.sharing.global.utils.openfeign.client.KakaoAddressFeign
import com.example.sharing.global.utils.openfeign.client.dto.response.SearchAddressResponse
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SearchAddressService(
    private val addressFeign: KakaoAddressFeign,
) {
    @Transactional
    fun execute(request: QueryAddressRequest): QueryAddressResponse {
        val address = addressFeign.queryAddress(request.keyword, request.page, request.size)
        return QueryAddressResponse(address.meta.totalCount, address.meta.isEnd, parseSearchAddressResponse(address))
    }

    fun parseSearchAddressResponse(response: SearchAddressResponse): List<AddressElement> {
        return response.documents.map { document ->
            AddressElement(
                x = document.x.toDouble(),
                y = document.y.toDouble(),
                addressName = document.address?.addressName ?: "",
                roadAddressName = document.roadAddress?.addressName ?: "",
                buildingName = document.roadAddress?.buildingName ?: ""
            )
        }
    }
}