package com.example.sharing.domain.chat.service

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import com.example.sharing.domain.chat.domain.Chat
import com.example.sharing.domain.chat.domain.repository.ChatRepository
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.presentation.dto.ChatResponse
import com.example.sharing.domain.chat.presentation.dto.SendChatRequest
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class SendChatService(
    private val chatRepository: ChatRepository,
    private val userFacade: UserFacade,
    private val roomFacade: RoomFacade,
) {
    @Transactional
    fun execute(socketIOServer: SocketIOServer, socketIOClient: SocketIOClient, request: SendChatRequest) {
        val user = userFacade.getCurrentUser()
        val room = roomFacade.getCurrentRoom(socketIOClient)

        val chat = chatRepository.save(
            Chat(
                id = UUID.randomUUID(),
                text = request.message,
                user = user,
                room = room

            )
        )

        room.updateLastTextAndLastSendAt(request.message, LocalDateTime.now(), LocalDateTime.now())

        socketIOServer.getRoomOperations(room.id.toString())
            .clients.forEach { client -> client.sendEvent("chat", ChatResponse.of(chat, client == socketIOClient)) }
    }
}