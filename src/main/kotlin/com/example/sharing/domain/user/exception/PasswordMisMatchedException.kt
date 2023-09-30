package com.example.sharing.domain.user.exception

import com.example.sharing.global.error.exception.ErrorCode.PASSWORD_MISMATCED
import com.example.sharing.global.error.exception.SharingException

class PasswordMisMatchedException : SharingException(PASSWORD_MISMATCED) {
    companion object {
        @JvmField
        val EXCEPTION = PasswordMisMatchedException()
    }
}