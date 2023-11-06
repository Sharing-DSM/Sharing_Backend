package com.example.sharing.domain.schedule.presentation.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

class UpdateScheduleRequest (
    @field:NotBlank(message = "title는 Null를 허용하지 않습니다.")
    @field:Size(max = 10, message = "title은 10자 이하여야 합니다.")
    var title: String,

    @field:NotBlank(message = "year르 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:NotNull
    @field:Length(max = 4)
    val year: String,

    @field:NotBlank(message = "month르 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:NotNull
    @field:Length(max = 2)
    val month: String,

    @field:NotBlank(message = "day르 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:NotNull
    @field:Length(max = 2)
    val day: String,
)