package com.example.sharing.domain.chat.service

import com.example.sharing.domain.chat.domain.Chat
import com.example.sharing.domain.chat.domain.repository.ChatRepository
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.presentation.dto.ChatResponse
import com.example.sharing.domain.chat.presentation.dto.QueryChatListResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QueryChatListService(
    private val userFacade: UserFacade,
    private val roomFacade: RoomFacade,
    private val chatRepository: ChatRepository,
) {
    @Transactional(readOnly = true)
    fun execute(roomId: UUID): QueryChatListResponse {
        val user = userFacade.getCurrentUser()
        val room = roomFacade.getRoomById(roomId)

        return QueryChatListResponse(
            chatRepository.findAllById(room.id)
                .stream()
                .map { chat -> ChatResponse.of(chat as Chat, chat.user.name == user.name)}
                .toList()
        )
    }
}