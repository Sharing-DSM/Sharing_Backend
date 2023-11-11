package com.example.sharing.global.socket.utils

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.chat.exception.InvalidUserException
import com.example.sharing.domain.chat.exception.RoomNotfoundException
import java.util.*

object SocketUtil {
    fun getUserId(socketIOClient: SocketIOClient): UUID {
        if(!socketIOClient.has("user")) {
            throw InvalidUserException.EXCEPTION
        }

        return socketIOClient.get("user")
    }

    fun getRoomId(socketIOClient: SocketIOClient): UUID {

        if(!socketIOClient.has("room")) {
            throw RoomNotfoundException.EXCEPTION
        }

        return socketIOClient.get("user") as UUID
    }
}