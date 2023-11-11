package com.example.sharing.global.socket

import com.corundumstudio.socketio.SocketIOClient
import com.corundumstudio.socketio.annotation.OnConnect
import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.global.security.jwt.JwtTokenProvider
import com.example.sharing.global.socket.facade.SocketRoomFacade
import org.springframework.stereotype.Component

@Component
class SocketConnectListener(
    private val jwtTokenProvider: JwtTokenProvider,
    private val socketRoomFacade: SocketRoomFacade,
    private val userFacade: UserFacade,
) {
    @OnConnect
    fun onConnect(socketIOClient: SocketIOClient) {
        val token: String? = jwtTokenProvider.resolveToken(socketIOClient)
        val authorization = jwtTokenProvider.authorization(token)
        val accountId = authorization.name
        val user = userFacade.getByAccountId(accountId)

        socketIOClient.set("user", user.id)
        socketRoomFacade.joinAllRoom(socketIOClient, user)
    }
}