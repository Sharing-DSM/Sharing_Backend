package com.example.sharing.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    PASSWORD_MISMATCED(400, "Password Mis Matched"),
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),
    BAD_FILE_EXTENSION(400, "Bad File Extension"),

    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),
    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),
    DEVICE_TOKEN_INVALID(401, "Device Token Invalid"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),
    INVALID_USER(403, "Invalid User"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),
    ROOM_NOT_FOUND(404, "Room Not found"),
    ROOM_USER_NOT_FOUND(404, "Room User Not Found"),
    SCHEDULE_NOT_FOUND(404, "Schedule Not Found"),
    USER_INTEREST_AREA_NOT_FOUND(404, "User Interest Area Not Found"),

    ALREADY_ACCOUNT_ID_EXISTS(409, "Already Account Id Exists"),
    ALREADY_ROOM_EXISTS(409, "Already Room Exists"),
    ALREADY_APPLY(409, "Already apply"),

    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}