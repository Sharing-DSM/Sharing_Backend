package com.example.sharing.domain.feed.presentation.dto.response

data class QueryAddressResponse (
    val totalPage: Int,
    val isPageEnd: Boolean,
    val address: List<AddressElement>
) {
    data class AddressElement (
        val x: Double,
        val y: Double,
        val addressName: String?,
        val roadAddressName: String?,
        val buildingName: String?,
    )
}