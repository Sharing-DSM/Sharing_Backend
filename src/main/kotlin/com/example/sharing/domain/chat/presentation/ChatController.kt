package com.example.sharing.domain.chat.presentation

import com.example.sharing.domain.chat.service.CreateRoomService
import com.example.sharing.domain.chat.service.QueryChatListService
import com.example.sharing.domain.chat.service.QueryMyRoomListService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.ResponseStatus
import org.springframework.web.bind.annotation.RestController
import java.util.*

@RequestMapping("/chats")
@RestController
class ChatController(
    private val createRoomService: CreateRoomService,
    private val queryChatListService: QueryChatListService,
    private val queryMyRoomListService: QueryMyRoomListService,
) {
    @ResponseStatus(CREATED)
    @PostMapping("/{user-id}")
    fun createRoom(@PathVariable("user-id") userId: UUID) = createRoomService.execute(userId)

    @GetMapping("/{room-id}")
    fun queryChatList(@PathVariable("room-id") roomId: UUID) = queryChatListService.execute(roomId)

    @GetMapping("/room")
    fun queryMyRoom() = queryMyRoomListService.execute()
}
