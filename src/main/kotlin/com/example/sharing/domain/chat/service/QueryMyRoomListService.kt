package com.example.sharing.domain.chat.service

import com.example.sharing.domain.chat.domain.repository.RoomRepository
import com.example.sharing.domain.chat.presentation.dto.QueryMyRoomListResponse
import com.example.sharing.domain.chat.presentation.dto.RoomResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryMyRoomListService(
    private val userFacade: UserFacade,
    private val roomRepository: RoomRepository,
) {
    @Transactional(readOnly = true)
    fun execute(): QueryMyRoomListResponse {
        val user = userFacade.getCurrentUser()
        return QueryMyRoomListResponse(
            roomRepository.findAllByUserA(user)
                .stream()
                .map(RoomResponse::of)
                .toList()
        )
    }
}