package com.example.sharing.global.utils.openfeign.client.exception

import com.example.sharing.global.error.exception.ErrorCode.FEIGN_FORBIDDEN
import com.example.sharing.global.error.exception.SharingException

class FeignForbiddenException : SharingException(FEIGN_FORBIDDEN) {
    companion object {
        @JvmField
        val EXCEPTION = FeignForbiddenException()
    }
}
