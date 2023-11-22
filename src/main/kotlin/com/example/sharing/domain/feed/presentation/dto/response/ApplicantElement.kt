package com.example.sharing.domain.feed.presentation.dto.response

import java.time.LocalDateTime
import java.util.*

data class ApplicantElement(
    val userId: UUID,
    val userProfile: String,
    val userName: String,
    val appliedAt: LocalDateTime
)
