package com.example.sharing.domain.user.presentation.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull

data class UserSignUpRequest (
    @field:NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Length(max = 15, message = "15자까지 가능합니다")
    var accountId: String,

    @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Length(max = 60)
    val password: String,

    @field:NotNull
    @field:Length(max = 6)
    val name: String,

    @field:NotNull
    @field:Length(max = 3, message = "3자리 숫자가 넘어가선 안됩니다.")
    val age: Int,
)