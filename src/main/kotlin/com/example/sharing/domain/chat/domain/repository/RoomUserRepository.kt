package com.example.sharing.domain.chat.domain.repository

import com.example.sharing.domain.chat.domain.Room
import com.example.sharing.domain.chat.domain.RoomUser
import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoomUserRepository: JpaRepository<RoomUser, UUID> {
    fun findAllByUser(user: User): List<RoomUser>
    fun existsByRoomAndUser(room: Room, user: User): Boolean
    fun findByRoomIdAndUserId(roomId: UUID, userId: UUID): RoomUser
}