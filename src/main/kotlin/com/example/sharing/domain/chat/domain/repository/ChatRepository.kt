package com.example.sharing.domain.chat.domain.repository

import com.example.sharing.domain.chat.domain.Chat
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ChatRepository: JpaRepository<Chat, UUID> {
    fun findAllById(id: UUID): List<Chat>
}