package com.example.sharing.global.exception

import com.example.sharing.global.error.exception.ErrorCode.TOKEN_EXPIRED
import com.example.sharing.global.error.exception.SharingException

object TokenExpiredExcpetion : SharingException(TOKEN_EXPIRED) {
    val EXCPETION = TokenExpiredExcpetion
}