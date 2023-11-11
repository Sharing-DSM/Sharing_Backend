package com.example.sharing.domain.chat.presentation.dto

data class JoinRoomRequest(
    val roomId: String
) {
    constructor() : this(String())
}