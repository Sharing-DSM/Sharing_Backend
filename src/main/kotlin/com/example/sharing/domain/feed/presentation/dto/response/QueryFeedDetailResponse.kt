package com.example.sharing.domain.feed.presentation.dto.response

import com.example.sharing.domain.feed.domain.type.Type
import java.util.*

data class QueryFeedDetailResponse(
    val feedId: UUID,
    val title: String,
    val addressName: String,
    val roadAddressName: String,
    val x: Double,
    val y: Double,
    val recruitment: Int,
    val volunteerTime: Int,
    val content: String,
    val isEmergency: Boolean,
    val isMine: Boolean,
    val type: Type,
    val userId: UUID,
    val userProfile: String
)