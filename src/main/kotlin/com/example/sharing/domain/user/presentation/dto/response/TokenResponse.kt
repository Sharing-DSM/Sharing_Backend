package com.example.sharing.domain.user.presentation.dto.response

data class TokenResponse(
    val accessToken: String,
    val refreshToken: String
)