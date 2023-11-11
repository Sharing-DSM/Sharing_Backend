package com.example.sharing.domain.chat.presentation.dto

import com.fasterxml.jackson.annotation.JsonProperty
import java.util.*

data class JoinRoomRequest(
    @JsonProperty("room_id")
    val roomId: UUID
)