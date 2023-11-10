package com.example.sharing.domain.user.presentation.dto.request

data class UpdateUserInfoRequest(
    val name: String,
    val accountId: String,
    val age: Int
)