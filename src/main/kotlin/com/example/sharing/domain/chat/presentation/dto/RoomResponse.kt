package com.example.sharing.domain.chat.presentation.dto

import com.example.sharing.domain.chat.domain.RoomUser
import com.example.sharing.domain.user.domain.User
import java.time.LocalDateTime
import java.util.*

data class RoomResponse(
    val roomId: UUID,
    val lastChat: String,
    val lastSendAt: LocalDateTime,
    val isRead: Boolean,
    val roomName: String,
    val userProfile: String,
) {
    companion object {
        fun of(roomUser: RoomUser, userB: User): RoomResponse {
            val room = roomUser.room
            return RoomResponse(
                roomId = room.id,
                lastChat = room.lastText,
                lastSendAt = room.lastSendAt,
                isRead = room.lastSendAt.isBefore(roomUser.lastReadAt),
                roomName = userB.name,
                userProfile = userB.profile
            )
        }
    }
}