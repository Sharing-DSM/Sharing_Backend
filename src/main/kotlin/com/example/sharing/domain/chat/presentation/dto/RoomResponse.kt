package com.example.sharing.domain.chat.presentation.dto

import com.example.sharing.domain.chat.domain.Room
import java.time.LocalDateTime
import java.util.*

data class RoomResponse(
    val roomId: UUID,
    val lastChat: String?,
    val lastSendAt: LocalDateTime?,
    val isRead: Boolean,
    val roomName: String
) {
    companion object {
        fun of(room: Room): RoomResponse {
            return RoomResponse(
                roomId = room.id,
                lastChat = room.lastText,
                lastSendAt = room.lastSendAt,
                isRead = room.lastSendAt!!.isBefore(room.lastReadAt),
                roomName = room.userB.name
            )
        }
    }
}