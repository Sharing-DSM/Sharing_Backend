package com.example.sharing.domain.chat.facade

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.chat.domain.Room
import com.example.sharing.domain.chat.domain.repository.PrivateRoomRepository
import com.example.sharing.domain.chat.domain.repository.RoomRepository
import com.example.sharing.domain.chat.exception.RoomAlreadyExistsException
import com.example.sharing.domain.chat.exception.RoomNotfoundException
import com.example.sharing.domain.user.domain.User
import com.example.sharing.global.socket.utils.SocketUtil
import org.springframework.stereotype.Component
import java.util.*

@Component
class RoomFacade(
    private val roomRepository: RoomRepository,
    private val privateRoomRepository: PrivateRoomRepository
) {
    fun getRoomById(roomId: UUID): Room {
        return roomRepository.findById(roomId)
            .orElseThrow { RoomNotfoundException.EXCEPTION }
    }

    fun getCurrentRoom(socketIOClient: SocketIOClient): Room {
        return getRoomById(SocketUtil.getRoomId(socketIOClient))
    }

    fun checkRoomExist(userA: User, userB: User) {
        if(privateRoomRepository.existsByUserAAndUserB(userA, userB)) {
            throw RoomAlreadyExistsException.EXCEPTION
        }
    }
}