package com.example.sharing.domain.feed.presentation.dto.request

import com.example.sharing.domain.feed.domain.type.Type

data class UpdateFeedRequest (
    val title: String,

    val content: String,

    val addressName: String,

    val roadAddressName: String,

    val type: Type,

    val x: Double,

    val y: Double,

    val recruitment: Int,

    val volunteerTime: Int,

    val isEmergency: Boolean
)