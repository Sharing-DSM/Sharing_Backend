package com.example.sharing.domain.user.presentation.dto.response

data class QueryUserResponse(
    val name: String,
    val accountId: String,
    val age: Int,
    val profile: String?
)