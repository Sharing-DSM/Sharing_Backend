package com.example.sharing.domain.user.exception

import com.example.sharing.global.error.exception.ErrorCode.USER_NOT_FOUND
import com.example.sharing.global.error.exception.SharingException

class UserNotFoundException : SharingException(USER_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = UserNotFoundException()
    }
}