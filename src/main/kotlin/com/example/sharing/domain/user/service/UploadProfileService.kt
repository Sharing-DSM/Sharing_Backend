package com.example.sharing.domain.user.service

import com.example.sharing.domain.user.facade.UserFacade
import com.example.sharing.domain.user.presentation.dto.response.UploadProfileResponse
import com.example.sharing.global.utils.aws.s3.S3Utils
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import org.springframework.web.multipart.MultipartFile

@Service
class UploadProfileService(
    private val userFacade: UserFacade,
    private val s3Utils: S3Utils
) {
    @Transactional
    fun execute(file: MultipartFile): UploadProfileResponse {
        val user = userFacade.getCurrentUser()
        val url = s3Utils.upload(file)
        user.update(url)
        return UploadProfileResponse(url)
    }
}