package com.example.sharing.domain.chat.presentation.dto

import com.example.sharing.domain.chat.domain.Chat
import java.util.*

data class ChatResponse(
    val roomId: UUID,
    val isMine: Boolean,
    val message: String,
) {
    companion object {
        fun of(chat: Chat, isMine: Boolean): ChatResponse {
            return ChatResponse(
                roomId = chat.room.id,
                isMine = isMine,
                message = chat.text
            )
        }
    }
}