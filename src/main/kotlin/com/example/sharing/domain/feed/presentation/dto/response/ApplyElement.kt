package com.example.sharing.domain.feed.presentation.dto.response

import com.example.sharing.domain.feed.domain.Feed
import java.time.LocalDateTime
import java.util.*

data class ApplyElement(
    val id: UUID,
    val feed: Feed,
    val appliedAt: LocalDateTime
)