package com.example.sharing.domain.feed.exception

import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class AlreadyApplyException: SharingException(ALREADY_APPLY) {
    companion object {
        @JvmField
        val EXCEPTION = AlreadyApplyException()
    }
}