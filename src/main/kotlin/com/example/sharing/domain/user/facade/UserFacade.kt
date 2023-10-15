package com.example.sharing.domain.user.facade

import com.example.sharing.domain.user.domain.User
import com.example.sharing.domain.user.domain.repository.UserRepository
import com.example.sharing.domain.user.exception.UserNotFoundException
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.stereotype.Component
import java.util.*

@Component
class UserFacade(
    private val userRepository: UserRepository
) {
    fun getCurrentUser(): User {
        val accountId: String = SecurityContextHolder.getContext().authentication.name
        println(accountId)
        return getByAccountId(accountId)
    }

    fun checkUserExist(accountId: String): Boolean {
        return userRepository.existsByAccountId(accountId)
    }

    fun getByAccountId(accountId: String): User {
        return userRepository.findByAccountId(accountId)?: throw UserNotFoundException.EXCEPTION
    }

    fun getUserId(): UUID {
        return getCurrentUser().id
    }
}