package com.example.sharing.domain.chat.service

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import com.example.sharing.domain.chat.domain.Chat
import com.example.sharing.domain.chat.domain.repository.ChatRepository
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.presentation.dto.ChatResponse
import com.example.sharing.domain.chat.presentation.dto.SendChatRequest
import com.example.sharing.domain.user.facade.UserFacade
import com.fasterxml.jackson.databind.JsonMappingException
import com.fasterxml.jackson.databind.ObjectMapper
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class SendChat2Service(
    private val chatRepository: ChatRepository,
    private val userFacade: UserFacade,
    private val roomFacade: RoomFacade,
    private val objectMapper: ObjectMapper,
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
            .clients.forEach { client ->
                try {
                    client.sendEvent(
                        "chat",
                        objectMapper.writeValueAsString(ChatResponse.of(chat, client == socketIOClient))
                    )
                } catch (ignore: JsonMappingException) { }
            }
    }
}