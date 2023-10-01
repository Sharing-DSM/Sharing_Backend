package com.example.sharing.global.exception

import com.example.sharing.global.error.exception.ErrorCode.TOKEN_INVALID
import com.example.sharing.global.error.exception.SharingException

object TokenInvalidException : SharingException(TOKEN_INVALID) {
    var EXCEPTION = TokenInvalidException
}