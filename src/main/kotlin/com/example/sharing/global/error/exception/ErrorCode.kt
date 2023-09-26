package com.example.sharing.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    INTENAL_SERVER_ERROR(500, "Internal Server Error");
}