package com.example.sharing.domain.feed.presentation.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateFeedRequest(
    @field:NotBlank(message = "title는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 20, message = "title는 20자 이하여야 합니다.")
    val title: String,

    @field:NotBlank(message = "content는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 2000, message = "content는 2000자 이하여야 합니다.")
    val content: String,

    @field:NotNull
    @field:Length(max = 100)
    val addressName: String,

    @field:NotNull
    @field:Length(max = 100)
    val roadAddressName: String,

    @field:NotNull
    val x: Double,

    @field:NotNull
    val y: Double,

    @field:NotNull(message = "recruitment는 Null를 허용하지 않습니다.")
    val recruitment: Int,

    @field:NotNull(message = "volunteerTime는 Null를 허용하지 않습니다.")
    val volunteerTime: Int,
)
