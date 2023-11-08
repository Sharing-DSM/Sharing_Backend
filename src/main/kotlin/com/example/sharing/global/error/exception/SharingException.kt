package com.example.sharing.global.error.exception

abstract class SharingException(
    val errorCode: ErrorCode,
) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message

}