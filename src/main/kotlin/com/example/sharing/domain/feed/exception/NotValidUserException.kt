package com.example.sharing.domain.feed.exception

import com.example.sharing.global.error.exception.ErrorCode
import com.example.sharing.global.error.exception.SharingException

class NotValidUserException : SharingException(ErrorCode.NOT_VALID_USER) {
    companion object {
        @JvmField
        val EXCEPTION = NotValidUserException()
    }
}