package com.example.sharing.domain.chat.service

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.global.socket.facade.SocketRoomFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class JoinRoomService(
    private val userFacade: UserFacade,
    private val socketRoomFacade: SocketRoomFacade,
) {
    @Transactional
    fun execute(socketIOClient: SocketIOClient, roomId: UUID) {
        val user = userFacade.getCurrentUser()
        socketRoomFacade.joinRoom(socketIOClient, user, roomId)
    }
}