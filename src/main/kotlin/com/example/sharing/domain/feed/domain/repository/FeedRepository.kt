package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Feed
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.UUID

@Repository
interface FeedRepository: JpaRepository<Feed, UUID>