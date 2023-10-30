package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Feed
import com.example.sharing.domain.feed.presentation.dto.response.FeedElement
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface FeedRepository: JpaRepository<Feed, UUID> {
    fun findAllByOrderByViewsDesc(): List<FeedElement>
    fun findAllByAddressNameContaining(addressName: String): List<FeedElement>
}