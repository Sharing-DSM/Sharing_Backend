package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.presentation.dto.response.ApplyElement
import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ApplyRepository: JpaRepository<Apply, UUID> {
    fun findAllByUserOrderByAppliedAtDesc(user: User): List<ApplyElement>
    fun findAllByFeedId(feedId: UUID): List<Apply>
}