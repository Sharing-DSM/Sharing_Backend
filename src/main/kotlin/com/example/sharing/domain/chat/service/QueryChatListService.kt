package com.example.sharing.domain.chat.service

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
            chatRepository.findAllByRoom(room)
                .stream()
                .map { chat -> ChatResponse(roomId = chat.room.id, isMine = chat.user.id == user.id, message = chat.text, sendAt = chat.sendAt)}
                .toList()
        )
    }
}