package com.example.sharing.domain.feed.presentation.dto.response

import com.example.sharing.domain.feed.domain.type.Type
import java.time.LocalDateTime
import java.util.*

data class ApplyElement(
    val id: UUID,
    val feedId: UUID,
    val feedTitle: String,
    val feedAddressName: String,
    val feedType: Type,
    val appliedAt: LocalDateTime
)