package com.example.sharing.domain.chat.domain.repository

import com.example.sharing.domain.chat.domain.Room
import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoomRepository: JpaRepository<Room, UUID> {
    fun existsRoomByUserAAndUserB(userA: User, userB: User): Boolean
    fun findAllByUserA(userA: User): List<Room>
}