package com.example.sharing.domain.feed.presentation.dto.request

data class QueryAddressRequest (
    val keyword: String,
    val page: Int?,
    val size: Int?,
)