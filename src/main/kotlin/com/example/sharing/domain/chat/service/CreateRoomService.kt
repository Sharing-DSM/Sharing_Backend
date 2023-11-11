package com.example.sharing.domain.chat.service

import com.example.sharing.domain.chat.domain.PrivateRoom
import com.example.sharing.domain.chat.domain.Room
import com.example.sharing.domain.chat.domain.repository.PrivateRoomRepository
import com.example.sharing.domain.chat.domain.repository.RoomRepository
import com.example.sharing.domain.chat.domain.type.RoomType.*
import com.example.sharing.domain.chat.facade.RoomFacade
import com.example.sharing.domain.chat.presentation.dto.CreateRoomResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDateTime
import java.util.*

@Service
class CreateRoomService(
    private val roomRepository: RoomRepository,
    private val privateRoomRepository: PrivateRoomRepository,
    private val roomFacade: RoomFacade,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(userId: UUID): CreateRoomResponse {
        val userA = userFacade.getCurrentUser()
        val userB = userFacade.getUserById(userId)
        val room = roomRepository.save(Room(
            id = UUID.randomUUID(),
            roomType = PRIVATE,
            lastText = "",
            lastSendAt = LocalDateTime.now()))

        roomFacade.checkRoomExist(userA, userB)

        privateRoomRepository.save(PrivateRoom(UUID.randomUUID(),userA, userB, room))

        return CreateRoomResponse(room.id)
    }
}