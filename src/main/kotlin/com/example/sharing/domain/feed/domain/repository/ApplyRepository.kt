package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.domain.ApplyId
import com.example.sharing.domain.feed.domain.Feed
import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface ApplyRepository: JpaRepository<Apply, ApplyId> {

    fun findByFeedAndUser(feed: Feed, user: User): Optional<Apply>
}