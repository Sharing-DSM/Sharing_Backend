package com.example.sharing.domain.chat.presentation

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.SocketIOServer
import com.corundumstudio.socketio.annotation.OnEvent
import com.example.sharing.domain.chat.presentation.dto.SendChatRequest
import com.example.sharing.domain.chat.service.JoinRoomService
import com.example.sharing.domain.chat.service.SendChat2Service
import com.example.sharing.domain.chat.service.SendChatService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*
import javax.validation.Valid

@RestController
class ChatSocketController(
    private val socketIOServer: SocketIOServer,
    private val sendChatService: SendChatService,
    private val sendChat2Service: SendChat2Service,
    private val joinRoomService: JoinRoomService,
) {
    @ResponseStatus(NO_CONTENT)
    @OnEvent("join")
    fun joinRoom(socketIOClient: SocketIOClient, @PathVariable("room-id") roomId: UUID) {
        joinRoomService.execute(socketIOClient, roomId)
    }

    @OnEvent("chat")
    fun sendChat(socketIOClient: SocketIOClient, @RequestBody @Valid request: SendChatRequest) {
        sendChatService.execute(socketIOServer, socketIOClient, request)
    }

    @OnEvent("chat2")
    fun sendChat2(socketIOClient: SocketIOClient, @RequestBody @Valid request: SendChatRequest) {
        sendChat2Service.execute(socketIOServer, socketIOClient, request)
    }
}