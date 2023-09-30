package com.example.sharing.domain.user.domain.repository

import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.UUID

interface UserRepository : JpaRepository<User, UUID> {
    fun findByAccountId(accountId: String): User?
    fun existsByAccountId(accountd: String): Boolean
}