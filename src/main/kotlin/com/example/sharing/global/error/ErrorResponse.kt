package com.example.sharing.global.error

import com.example.sharing.global.error.exception.SharingException

class ErrorResponse<T>(
    val status: Int,
    val message: String,
) {
    companion object {
        fun of(e: SharingException): ErrorResponse<Unit> {
            return ErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}