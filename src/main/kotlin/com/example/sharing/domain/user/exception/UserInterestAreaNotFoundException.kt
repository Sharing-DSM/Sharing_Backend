package com.example.sharing.domain.user.exception

import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class UserInterestAreaNotFoundException: SharingException(USER_INTEREST_AREA_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = UserInterestAreaNotFoundException()
    }
}