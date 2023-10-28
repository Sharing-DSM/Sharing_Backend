package com.example.sharing.domain.feed.exception

import com.example.sharing.global.error.exception.ErrorCode.FEED_NOT_FOUND
import com.example.sharing.global.error.exception.SharingException

class FeedNotFoundException : SharingException(FEED_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = FeedNotFoundException()
    }
}