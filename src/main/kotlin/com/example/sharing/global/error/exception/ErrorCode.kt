package com.example.sharing.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    PASSWORD_MISMATCED(400, "Password Mis Matched"),

    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),

    USER_NOT_FOUND(404, "User Not Found"),

    ALREADY_ACCOUNT_ID_EXISTS(409, "Already Account Id Exists"),

    INTENAL_SERVER_ERROR(500, "Internal Server Error");
}