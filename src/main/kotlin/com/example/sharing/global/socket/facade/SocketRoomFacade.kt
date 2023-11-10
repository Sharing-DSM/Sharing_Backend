package com.example.sharing.global.socket.facade

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.user.domain.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class SocketRoomFacade(
    private val roomFacade: RoomFacade,
) {
    fun joinRoom(socketIOClient: SocketIOClient, user: User, roomId: UUID) {
        val room = roomFacade.getRoomById(roomId)

        roomFacade.checkRoomExist(room.userA, room.userB)

        socketIOClient.allRooms.forEach(socketIOClient::leaveRoom)

        socketIOClient.set("room", roomId)
        socketIOClient.joinRoom(roomId.toString())

    }
}