package com.example.sharing.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    ALREADY_ACCOUNT_ID_EXISTS(409, "Already Account Id Exists"),

    INTENAL_SERVER_ERROR(500, "Internal Server Error");
}