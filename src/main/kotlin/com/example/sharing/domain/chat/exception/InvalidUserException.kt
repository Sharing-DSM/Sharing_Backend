package com.example.sharing.domain.chat.exception

import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class InvalidUserException: SharingException(INVALID_USER) {
    companion object {
        @JvmField
        val EXCEPTION = InvalidUserException()
    }
}