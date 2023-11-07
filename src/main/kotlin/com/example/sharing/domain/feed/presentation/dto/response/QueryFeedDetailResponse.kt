package com.example.sharing.domain.feed.presentation.dto.response

import java.util.*

<<<<<<< main
data class QueryFeedDetailResponse(
=======
data class QueryFeedDetailResponse (
>>>>>>> ♻️ :: 컨플릭트 해결
    val feedId: UUID,
    val title: String,
    val addressName: String,
    val recruitment: Int,
    val volunteerTime: Int,
    val content: String,
    val isMine: Boolean,
)