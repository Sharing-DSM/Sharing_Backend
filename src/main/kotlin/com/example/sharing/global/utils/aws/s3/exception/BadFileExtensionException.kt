package com.example.sharing.global.utils.aws.s3.exception

import com.example.sharing.global.error.exception.ErrorCode.*
import com.example.sharing.global.error.exception.SharingException

class BadFileExtensionException : SharingException(BAD_FILE_EXTENSION){
    companion object {
        @JvmField
        val EXCEPTION = BadFileExtensionException()
    }
}