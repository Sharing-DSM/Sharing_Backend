package com.example.sharing.domain.chat.facade

import com.example.sharing.domain.chat.domain.Room
import com.example.sharing.domain.chat.domain.RoomUser
import com.example.sharing.domain.chat.domain.repository.RoomUserRepository
import com.example.sharing.domain.chat.exception.RoomUserNotFoundException
import com.example.sharing.domain.user.domain.User
import org.springframework.stereotype.Component
import java.util.*

@Component
class RoomUserFacade(
    private val roomUserRepository: RoomUserRepository,
) {
    fun getByRoomAndUser(roomId: UUID, userId: UUID): RoomUser {
        return roomUserRepository.findByRoomIdAndUserId(roomId, userId)
    }

    fun getByUser(user: User): List<RoomUser> {
        return roomUserRepository.findAllByUser(user)
    }

    fun checkRoomUserExist(room: Room, user: User) {
        if (!roomUserRepository.existsByRoomAndUser(room, user)) {
            throw RoomUserNotFoundException.EXCEPTION
        }
    }
}