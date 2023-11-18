package com.example.sharing.domain.chat.domain.repository

import com.example.sharing.domain.chat.domain.PrivateRoom
import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface PrivateRoomRepository: JpaRepository<PrivateRoom, UUID> {
    fun findAllByUserA(userA: User): List<PrivateRoom>
    fun findByUserA(userA: User): PrivateRoom
    fun existsByUserAAndUserB(userA: User, userB: User): Boolean
}