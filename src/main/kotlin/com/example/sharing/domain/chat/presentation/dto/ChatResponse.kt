package com.example.sharing.domain.chat.presentation.dto

import com.example.sharing.domain.chat.domain.Chat
import com.fasterxml.jackson.annotation.JsonProperty
import java.time.LocalDateTime
import java.util.*

data class ChatResponse(
    val roomId: UUID,
    val isMine: Boolean,
    val message: String,
    @JsonProperty(value = "send_at")
    val sendAt: LocalDateTime,
    @JsonProperty(value = "user_name")
    val userName: String
) {
    companion object {
        fun of(chat: Chat, isMine: Boolean, userName: String): ChatResponse {
            return ChatResponse(
                roomId = chat.room.id,
                isMine = isMine,
                message = chat.text,
                sendAt = chat.sendAt,
                userName = userName
            )
        }
    }
}