package com.example.sharing.domain.schedule.presentation.dto.request

import java.time.LocalDate
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateScheduleRequest (
    @field:NotBlank(message = "title는 Null, 공백을 허용하지 않습니다.")
    @field:Size(max = 10, message = "title는 10자 이하여야 합니다.")
    val title: String,
    @field:NotNull
    val date: LocalDate
)