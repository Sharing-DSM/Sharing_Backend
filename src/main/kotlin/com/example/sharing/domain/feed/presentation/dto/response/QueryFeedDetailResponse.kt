package com.example.sharing.domain.feed.presentation.dto.response

import com.example.sharing.domain.user.domain.User
import java.util.*

data class QueryFeedDetailResponse(
    val feedId: UUID,
    val title: String,
    val addressName: String,
    val recruitment: Int,
    val volunteerTime: Int,
    val content: String,
    val isMine: Boolean,
    val user: User
)