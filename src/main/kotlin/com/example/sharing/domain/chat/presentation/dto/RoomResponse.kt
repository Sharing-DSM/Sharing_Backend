package com.example.sharing.domain.chat.presentation.dto

import com.example.sharing.domain.chat.domain.RoomUser
import java.time.LocalDateTime
import java.util.*

data class RoomResponse(
    val roomId: UUID,
    val lastChat: String,
    val lastSendAt: LocalDateTime?,
    val isRead: Boolean,
    val roomName: String,
    val userProfile: String?,
) {
    companion object {
        fun of(roomUser: RoomUser, roomName: String, userProfile: String?): RoomResponse {
            val user = roomUser.user
            val room = roomUser.room
            return RoomResponse(
                roomId = room.id,
                lastChat = room.lastText,
                lastSendAt = room.lastSendAt,
                isRead = room.lastSendAt.isBefore(roomUser.lastReadAt),
                roomName = roomName,
                userProfile = userProfile
            )
        }
    }
}