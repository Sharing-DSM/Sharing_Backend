package com.example.sharing.domain.chat.service

import com.example.sharing.domain.chat.domain.Room
import com.example.sharing.domain.chat.domain.repository.RoomRepository
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.presentation.dto.CreateRoomResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CreateRoomService(
    private val roomRepository: RoomRepository,
    private val roomFacade: RoomFacade,
    private val userFacade: UserFacade
) {
    @Transactional
    fun execute(userId: UUID): CreateRoomResponse {
        val userA = userFacade.getCurrentUser()
        val userB = userFacade.getUserById(userId)

        roomFacade.checkRoomExist(userA, userB)

        val room = roomRepository.save(Room(
            id = UUID.randomUUID(),
            userA = userA,
            userB = userB,
            lastText = null,
            lastSendAt = null,
            lastReadAt = null
        ))

        return CreateRoomResponse(roomId = room.id)
    }
}