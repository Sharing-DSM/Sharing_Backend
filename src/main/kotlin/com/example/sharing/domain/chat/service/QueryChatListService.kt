package com.example.sharing.domain.chat.service

import com.example.sharing.domain.chat.domain.repository.ChatRepository
import com.example.sharing.domain.chat.domain.repository.PrivateRoomRepository
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.facade.RoomUserFacade
import com.example.sharing.domain.chat.presentation.dto.ChatResponse
import com.example.sharing.domain.chat.presentation.dto.QueryChatListResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*
import java.util.stream.Collectors

@Service
class QueryChatListService(
    private val userFacade: UserFacade,
    private val roomFacade: RoomFacade,
    private val privateRoomRepository: PrivateRoomRepository,
    private val chatRepository: ChatRepository,
    private val roomUserFacade: RoomUserFacade,
) {
    @Transactional(readOnly = true)
    fun execute(roomId: UUID): QueryChatListResponse {
        val user = userFacade.getCurrentUser()
        val room = roomFacade.getRoomById(roomId)
        val roomUser = roomUserFacade.getByRoomAndUser(room.id, user.id)

        roomUser.updateLastReadAt(LocalDateTime.now())

        return QueryChatListResponse(
            chatRepository.findAllByRoom(room)
                .stream()
                .map { chat ->
                    ChatResponse.of(chat, chat.user.id == user.id)
                }
                .sorted()
                .collect(Collectors.toList()),
            userName = privateRoomRepository.findByRoomAndUserA(room, user).userB.name
        )
    }
}