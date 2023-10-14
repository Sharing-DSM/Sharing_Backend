package com.example.sharing.global.exception

import com.example.sharing.global.error.exception.ErrorCode.INTERNAL_SERVER_ERROR
import com.example.sharing.global.error.exception.SharingException

class InternalServerError : SharingException(INTERNAL_SERVER_ERROR) {
    companion object {
        @JvmField
        val EXCEPTION = InternalServerError()
    }
}