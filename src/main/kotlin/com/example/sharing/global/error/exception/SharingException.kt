package com.example.sharing.global.error.exception

open class SharingException(
    private val errorCode: ErrorCode,
) : RuntimeException() {
    val status: Int
        get() = errorCode.status

    override val message: String
        get() = errorCode.message

}