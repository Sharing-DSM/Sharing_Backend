package com.example.sharing.domain.chat.service

import com.example.sharing.domain.chat.domain.repository.PrivateRoomRepository
import com.example.sharing.domain.chat.facade.RoomUserFacade
import com.example.sharing.domain.chat.presentation.dto.QueryMyRoomListResponse
import com.example.sharing.domain.chat.presentation.dto.RoomResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class QueryMyRoomListService(
    private val userFacade: UserFacade,
    private val roomUserFacade: RoomUserFacade,
    private val privateRoomRepository: PrivateRoomRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): QueryMyRoomListResponse {
        val user = userFacade.getCurrentUser()
        val userBList = privateRoomRepository.findAllByUserA(user)

        return QueryMyRoomListResponse(
            roomUserFacade.getByUser(user)
                .stream()
                .flatMap { roomUser ->
                    userBList.stream()
                        .filter { privateRoom -> privateRoom.userA == user && privateRoom.room == roomUser.room }
                        .map { RoomResponse.of(roomUser, it.userB) }
                }
                .sorted(compareByDescending { roomUser -> roomUser.lastSendAt })
                .collect(Collectors.toList())
        )
    }
}