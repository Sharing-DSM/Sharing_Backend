package com.example.sharing.domain.feed.exception

<<<<<<< refs/remotes/origin/main
import com.example.sharing.global.error.exception.ErrorCode.FEED_NOT_FOUND
import com.example.sharing.global.error.exception.SharingException

class FeedNotFoundException : SharingException(FEED_NOT_FOUND) {
=======
import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class FeedNotFoundException: SharingException(FEED_NOT_FOUND) {
>>>>>>> ⚡️ :: tag 생성 api 작성
    companion object {
        @JvmField
        val EXCEPTION = FeedNotFoundException()
    }
}