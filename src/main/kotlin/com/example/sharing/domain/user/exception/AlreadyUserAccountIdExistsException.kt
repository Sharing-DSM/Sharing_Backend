package com.example.sharing.domain.user.exception

import com.example.sharing.global.error.exception.ErrorCode.ALREADY_ACCOUNT_ID_EXISTS
import com.example.sharing.global.error.exception.SharingException

class AlreadyUserAccountIdExistsException : SharingException(ALREADY_ACCOUNT_ID_EXISTS) {
    companion object {
        @JvmField
        val EXCEPTION = AlreadyUserAccountIdExistsException()
    }
}