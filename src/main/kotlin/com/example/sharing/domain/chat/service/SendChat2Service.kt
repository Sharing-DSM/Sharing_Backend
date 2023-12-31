package com.example.sharing.domain.chat.service

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import com.example.sharing.domain.chat.domain.Chat
import com.example.sharing.domain.chat.domain.repository.ChatRepository
import com.example.sharing.domain.chat.domain.repository.PrivateRoomRepository
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.facade.RoomUserFacade
import com.example.sharing.domain.chat.presentation.dto.ChatResponse
import com.example.sharing.domain.chat.presentation.dto.SendChatRequest
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.global.socket.utils.SocketUtil
import com.example.sharing.global.utils.firebase.notification.FcmService
import com.fasterxml.jackson.core.JsonProcessingException
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
    private val roomUserFacade: RoomUserFacade,
    private val objectMapper: ObjectMapper,
    private val fcmService: FcmService,
    private val privateRoomRepository: PrivateRoomRepository,
) {
    @Transactional
    fun execute(socketIOServer: SocketIOServer, socketIOClient: SocketIOClient, request: SendChatRequest) {
        val user = userFacade.getCurrentUser(socketIOClient)
        val room = roomFacade.getCurrentRoom(socketIOClient)
        val roomUser = roomUserFacade.getByRoomAndUser(room.id, user.id)
        val privateRoom = privateRoomRepository.findByRoomAndUserA(room, roomUser.user)
        val chat = chatRepository.save(
            Chat(
                id = UUID.randomUUID(),
                text = request.message,
                user = user,
                room = room,
                sendAt = LocalDateTime.now()

            )
        )

        room.updateLastTextAndLastSendAt(chat.text, chat.sendAt)
        roomUser.updateLastReadAt(LocalDateTime.now())

        socketIOServer.getRoomOperations(room.id.toString())
            .clients.forEach { client ->
                try {
                    client.sendEvent("chat", objectMapper.writeValueAsString(ChatResponse.of(chat, client == socketIOClient)))
                } catch (ignore: JsonProcessingException) {
                    val clientRoomUser = roomUserFacade.getByRoomAndUser(room.id, SocketUtil.getUserId(client))
                    clientRoomUser.updateLastReadAt(LocalDateTime.now())
                }
            }

        fcmService.sendMessage(privateRoom.userB.deviceToken, privateRoom.userA.name, chat.text)
    }
}
