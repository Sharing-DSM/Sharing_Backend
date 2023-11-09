package com.example.sharing.global.error.exception

enum class ErrorCode(
    val status: Int,
    val message: String,
) {
    PASSWORD_MISMATCED(400, "Password Mis Matched"),
    FEIGN_BAD_REQUEST(400, "Feign Bad Request"),

    TOKEN_EXPIRED(401, "Token Expired"),
    TOKEN_INVALID(401, "Token Invalid"),
    FEIGN_UNAUTHORIZED(401, "Feign Unauthorized"),

    FEIGN_FORBIDDEN(403, "Feign Forbidden"),
    NOT_VALID_USER(403, "Not Valid User"),

    USER_NOT_FOUND(404, "User Not Found"),
    FEED_NOT_FOUND(404, "Feed Not Found"),
    SCHEDULE_NOT_FOUND(404, "Schedule Not Found"),
    USER_INTEREST_AREA_NOT_FOUND(404, "User Interest Area Not Found"),

    ALREADY_ACCOUNT_ID_EXISTS(409, "Already Account Id Exists"),

    FEIGN_EXPIRED_TOKEN(419, "Feign Expired Token"),

    INTERNAL_SERVER_ERROR(500, "Internal Server Error");
}