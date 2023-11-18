package com.example.sharing.domain.chat.service

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.chat.presentation.dto.JoinRoomRequest
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.global.socket.facade.SocketRoomFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class JoinRoomService(
    private val userFacade: UserFacade,
    private val socketRoomFacade: SocketRoomFacade,
) {
    @Transactional
    fun execute(socketIOClient: SocketIOClient, request: JoinRoomRequest) {
        val user = userFacade.getCurrentUser(socketIOClient)

        if (request.isJoinRoom) {
            socketRoomFacade.joinRoom(socketIOClient, request.roomId!!, user)
        } else {
            socketRoomFacade.joinAllRoom(socketIOClient, user)
        }
    }
}