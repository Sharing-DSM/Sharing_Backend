package com.example.sharing.domain.feed.presentation.dto.response

import com.example.sharing.domain.feed.domain.type.Type
import java.util.*

data class FeedElement(
    val id: UUID,
    val title: String,
    val addressName: String,
    val type: Type,
)