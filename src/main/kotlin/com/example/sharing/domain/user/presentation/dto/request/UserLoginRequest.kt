package com.example.sharing.domain.user.presentation.dto.request

import javax.validation.constraints.NotBlank

data class UserLoginRequest(
    @field:NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    var accountId: String,

    @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    var password: String
)
