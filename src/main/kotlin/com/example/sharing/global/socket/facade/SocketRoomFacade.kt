package com.example.sharing.global.socket.facade

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.facade.RoomUserFacade
import com.example.sharing.domain.user.domain.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class SocketRoomFacade(
    private val roomFacade: RoomFacade,
    private val roomUserFacade: RoomUserFacade,
) {
    fun joinRoom(socketIOClient: SocketIOClient, roomId: UUID, user: User) {
        val room = roomFacade.getRoomById(roomId)

        roomUserFacade.checkRoomUserExist(room, user)

        socketIOClient.allRooms.forEach(socketIOClient::leaveRoom)
        socketIOClient.set("room", roomId)
        socketIOClient.joinRoom(roomId.toString())
    }

    fun joinAllRoom(socketIOClient: SocketIOClient, user: User) {
        roomUserFacade.getByUser(user)
            .stream()
            .map { it }
            .forEach { room -> socketIOClient.joinRoom(room.id.toString()) }
    }
}