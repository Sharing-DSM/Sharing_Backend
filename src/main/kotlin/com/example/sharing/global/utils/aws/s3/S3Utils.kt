package com.example.sharing.global.utils.aws.s3

import com.amazonaws.services.s3.AmazonS3Client
import com.amazonaws.services.s3.model.CannedAccessControlList
import com.amazonaws.services.s3.model.ObjectMetadata
import com.amazonaws.services.s3.model.PutObjectRequest
import com.amazonaws.util.IOUtils
import org.springframework.beans.factory.annotation.Value
import org.springframework.stereotype.Component
import org.springframework.web.multipart.MultipartFile
import java.io.ByteArrayInputStream
import java.util.*

@Component
class S3Utils(
    private val s3Client: AmazonS3Client,

    @Value("\${cloud.aws.s3.bucket}")
    private val bucketName: String,

    @Value("\${cloud.aws.s3.base-image-url}")
    private val baseImageUrl: String,

    @Value("\${cloud.aws.s3.prefix}")
    private val prefix: String
) {
    fun upload(file: MultipartFile, path: String): String {
        val fileName = UUID.randomUUID().toString() + "-" + file.originalFilename
        val objMeta = ObjectMetadata()

        val bytes = IOUtils.toByteArray(file.inputStream)
        objMeta.contentLength = bytes.size.toLong()

        val byteArrayIs = ByteArrayInputStream(bytes)

        s3Client.putObject(
            PutObjectRequest(bucketName, path + fileName, byteArrayIs, objMeta)
                .withCannedAcl(CannedAccessControlList.PublicRead)
        )

        return s3Client.getUrl(bucketName, bucketName + fileName).toString()
    }
}