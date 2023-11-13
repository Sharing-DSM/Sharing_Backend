package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Feed
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedRepository: JpaRepository<Feed, UUID> {
    fun findTop3ByOrderByViewsDesc(): List<FeedElement>
    fun findAllByAddressNameContaining(addressName: String): List<FeedElement>
    fun findAllByUser(user: User) : List<FeedElement>
}