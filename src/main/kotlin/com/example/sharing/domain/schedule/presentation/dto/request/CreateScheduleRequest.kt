package com.example.sharing.domain.schedule.presentation.dto.request

import org.hibernate.validator.constraints.Length
<<<<<<< main
import java.time.LocalDate
=======
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Size

data class CreateScheduleRequest (
    @field:NotBlank(message = "title는 Null, 공백을 허용하지 않습니다.")
    @field:Size(max = 10, message = "title는 10자 이하여야 합니다.")
    val title: String,
<<<<<<< main
  
    @field:NotNull
    val date: LocalDate
=======

    @field:NotNull
    @field:Length(max = 4)
    val year: String,

    @field:NotNull
    @field:Length(max = 2)
    val month: String,

    @field:NotNull
    @field:Length(max = 2)
    val day: String,
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
)