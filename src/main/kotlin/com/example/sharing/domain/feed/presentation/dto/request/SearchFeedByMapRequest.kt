package com.example.sharing.domain.feed.presentation.dto.request

data class SearchFeedByMapRequest(
    val keyword: String,
    val x: Double,
    val y: Double,
)