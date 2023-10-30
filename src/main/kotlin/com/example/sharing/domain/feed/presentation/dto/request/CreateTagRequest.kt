package com.example.sharing.domain.feed.presentation.dto.request

import javax.validation.constraints.NotBlank
import javax.validation.constraints.Size

data class CreateTagRequest(
    @field:NotBlank(message = "name는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 10, message = "name는 10자 이하여야 합니다.")
    val name: String,
)