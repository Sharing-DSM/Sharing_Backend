package com.example.sharing.global.exception

import com.example.sharing.global.error.exception.ErrorCode
import com.example.sharing.global.error.exception.SharingException

object InternalServerError : SharingException(ErrorCode.INTENAL_SERVER_ERROR) {
    val EXCEPTION = InternalServerError
}