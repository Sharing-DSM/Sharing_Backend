package com.example.sharing.global.utils.openfeign.client.dto.response

import com.fasterxml.jackson.annotation.JsonProperty

data class SearchAddressByXAndYResponse(
    val meta: MetaElement,
    val documents: List<DocumentElement>,
) {
    data class MetaElement(
        val totalCount: Int,
        val isEnd: Boolean
    )

    data class DocumentElement(
        val address: AddressElement,
    )

    data class AddressElement(
        @JsonProperty("region_1depth_name")
        val region1depthName: String
    )
}