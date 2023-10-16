package com.example.sharing.global.utils.openfeign.client.dto.response

data class SearchAddressResponse(
    val meta: MetaElement,
    val documents: List<DocumentElement>,
) {
    data class MetaElement(
        val totalCount: Int,
        val isEnd: Boolean
    )
    data class DocumentElement(
        val x: String,
        val y: String,
        val roadAddress: RoadAddressElement?,
        val address: AddressElement?,
    )

    data class AddressElement (
        val addressName: String,
    )

    data class RoadAddressElement (
        val addressName: String,
        val buildingName: String
    )
}