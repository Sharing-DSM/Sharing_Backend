package com.example.sharing.global.utils.firebase.notification.exception

import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class InvalidDeviceTokenLengthException: SharingException(DEVICE_TOKEN_INVALID) {
    companion object {
        @JvmField
        val EXCEPTION = InvalidDeviceTokenLengthException()
    }
}