package com.example.sharing.global.utils.openfeign

import com.example.sharing.global.exception.InternalServerError
import com.example.sharing.global.utils.openfeign.client.exception.FeignBadRequestException
import com.example.sharing.global.utils.openfeign.client.exception.FeignExpiredTokenException
import com.example.sharing.global.utils.openfeign.client.exception.FeignForbiddenException
import com.example.sharing.global.utils.openfeign.client.exception.FeignUnAuthorizedException
import feign.FeignException
import feign.Response
import feign.codec.ErrorDecoder

class FeignClientErrorDecoder : ErrorDecoder {
    override fun decode(methodKey: String, response: Response): Exception {
        if (response.status() >= 400) {
            when (response.status()) {
                400 -> throw FeignBadRequestException.EXCEPTION
                401 -> throw FeignUnAuthorizedException.EXCEPTION
                403 -> throw FeignForbiddenException.EXCEPTION
                419 -> throw FeignExpiredTokenException.EXCEPTION
                else -> throw InternalServerError.EXCEPTION
            }
        }

        return FeignException.errorStatus(methodKey, response)
    }
}