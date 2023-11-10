package com.example.sharing.domain.chat.exception

import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class RoomNotfoundException: SharingException(ROOM_NOT_FOUND) {
     companion object {
         @JvmField
         val EXCEPTION = RoomNotfoundException()
     }
}