package com.example.sharing.domain.chat.service

import com.example.sharing.domain.chat.domain.repository.PrivateRoomRepository
import com.example.sharing.domain.chat.domain.repository.RoomUserRepository
import com.example.sharing.domain.chat.presentation.dto.QueryMyRoomListResponse
import com.example.sharing.domain.chat.presentation.dto.RoomResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.stream.Collectors

@Service
class QueryMyRoomListService(
    private val userFacade: UserFacade,
    private val roomUserRepository: RoomUserRepository,
    private val privateRoomRepository: PrivateRoomRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): QueryMyRoomListResponse {
        val user = userFacade.getCurrentUser()
        return QueryMyRoomListResponse(
            roomUserRepository.findAllByUser(user)
                .stream()
                .map { RoomResponse.of(it, privateRoomRepository.findByUserA(user).userB.name) }
                .collect(Collectors.toList())
        )
    }
}