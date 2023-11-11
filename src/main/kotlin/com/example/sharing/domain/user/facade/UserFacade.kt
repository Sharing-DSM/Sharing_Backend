package com.example.sharing.domain.user.facade

import com.corundumstudio.socketio.SocketIOClient
import com.example.sharing.domain.user.domain.User
import com.example.sharing.domain.user.domain.repository.UserRepository
import com.example.sharing.domain.user.exception.UserNotFoundException
import com.example.sharing.global.socket.utils.SocketUtil
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val accountId: String = SecurityContextHolder.getContext().authentication.name
        return getByAccountId(accountId)
    }

    fun getCurrentUser(socketIOClient: SocketIOClient): User {
        return getUserById(SocketUtil.getUserId(socketIOClient))
    }

    fun checkUserExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId) ?: throw UserNotFoundException.EXCEPTION
    }

    fun getUserById(userId: UUID): User {
        return userRepository.findById(userId).orElseThrow { throw UserNotFoundException.EXCEPTION }
    }

    fun getUserId(): UUID {
        return getCurrentUser().id
    }
}