package com.example.sharing.domain.feed.domain

import java.io.Serializable
import java.util.UUID


data class ApplyId (
    var userId: UUID,
    var feedId: UUID?
) : Serializable {

    fun applyId(userId: UUID, feedId: UUID) {
        this.userId = userId
        this.feedId = feedId
    }

}