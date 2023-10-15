package com.example.sharing.global.utils.openfeign.client.exception

import com.example.sharing.global.error.exception.ErrorCode.FEIGN_BAD_REQUEST
import com.example.sharing.global.error.exception.SharingException


class FeignBadRequestException : SharingException(FEIGN_BAD_REQUEST) {
    companion object {
        @JvmField
        val EXCEPTION = FeignBadRequestException()
    }
}
