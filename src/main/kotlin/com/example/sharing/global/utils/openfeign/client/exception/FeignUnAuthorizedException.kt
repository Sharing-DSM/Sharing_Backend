package com.example.sharing.global.utils.openfeign.client.exception

import com.example.sharing.global.error.exception.ErrorCode.FEIGN_UNAUTHORIZED
import com.example.sharing.global.error.exception.SharingException

class FeignUnAuthorizedException : SharingException(FEIGN_UNAUTHORIZED) {
    companion object {
        @JvmField
        val EXCEPTION = FeignUnAuthorizedException()
    }
}
