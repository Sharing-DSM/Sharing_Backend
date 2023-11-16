package com.example.sharing.domain.chat.exception

import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class RoomAlreadyExistsException: SharingException(ALREADY_ROOM_EXISTS) {
    companion object {
        @JvmField
        val EXCEPTION = RoomAlreadyExistsException()
    }
}