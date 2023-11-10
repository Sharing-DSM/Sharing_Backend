package com.example.sharing.global.error

import com.example.sharing.global.error.exception.SharingException

class ErrorResponse(
    val status: Int,
    val message: String,
) {
    companion object {
        fun of(e: SharingException): ErrorResponse {
            return ErrorResponse(
                status = e.status,
                message = e.message
            )
        }
    }
}