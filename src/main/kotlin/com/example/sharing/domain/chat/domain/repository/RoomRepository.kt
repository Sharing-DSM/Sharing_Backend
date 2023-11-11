package com.example.sharing.domain.chat.domain.repository

import com.example.sharing.domain.chat.domain.Room
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface RoomRepository: JpaRepository<Room, UUID> {
}