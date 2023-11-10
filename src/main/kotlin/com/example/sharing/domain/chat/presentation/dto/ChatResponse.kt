package com.example.sharing.domain.chat.presentation.dto

import com.example.sharing.domain.chat.domain.Chat
import java.time.LocalDateTime
import java.util.*

data class ChatResponse(
    val roomId: UUID,
    val isMine: Boolean,
    val sendAt: LocalDateTime?,
    val userName: String,
    val message: String,
) {
    companion object {
        fun of(chat: Chat, isMine: Boolean): ChatResponse {
            val user = chat.user
            return ChatResponse(
                roomId = chat.room.id,
                isMine = isMine,
                sendAt = chat.room.lastSendAt,
                userName = user.name,
                message = chat.text
            )
        }
    }
}