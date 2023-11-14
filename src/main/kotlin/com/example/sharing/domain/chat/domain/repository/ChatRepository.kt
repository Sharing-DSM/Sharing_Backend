package com.example.sharing.domain.chat.domain.repository

import com.example.sharing.domain.chat.domain.Chat
import com.example.sharing.domain.chat.domain.Room
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ChatRepository: JpaRepository<Chat, UUID> {
    fun findAllByRoom(room: Room): List<Chat>
}