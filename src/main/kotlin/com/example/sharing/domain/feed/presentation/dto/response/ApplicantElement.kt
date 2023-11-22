package com.example.sharing.domain.feed.presentation.dto.response

import java.time.LocalDateTime

data class ApplicantElement(
    val userAccountId: String,
    val userProfile: String,
    val userName: String,
    val appliedAt: LocalDateTime
)
