package com.example.sharing.domain.schedule.exception

import com.example.sharing.global.error.exception.ErrorCode
import com.example.sharing.global.error.exception.SharingException

class ScheduleNotFoundException : SharingException(ErrorCode.SCHEDULE_NOT_FOUND) {
    companion object {
        @JvmField
        val EXCEPTION = ScheduleNotFoundException()
    }
}