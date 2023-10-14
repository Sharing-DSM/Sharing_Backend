package com.example.sharing.global.utils.openfeign.client.exception

import com.example.sharing.global.error.exception.ErrorCode.FEIGN_EXPIRED_TOKEN
import com.example.sharing.global.error.exception.SharingException

class FeignExpiredTokenException : SharingException(FEIGN_EXPIRED_TOKEN) {
    companion object {
        @JvmField
        val EXCEPTION = FeignExpiredTokenException()
    }
}
