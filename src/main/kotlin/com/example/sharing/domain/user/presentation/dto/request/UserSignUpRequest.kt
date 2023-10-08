package com.example.sharing.domain.user.presentation.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotBlank
import javax.validation.constraints.NotNull
import javax.validation.constraints.Pattern
import javax.validation.constraints.Size

data class UserSignUpRequest (
    @field:NotBlank(message = "account_id는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(min = 5, max = 15, message = "account_id는 8자 이상 20자 이하여야 합니다.")
    var accountId: String,

    @field:NotBlank(message = "password는 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Pattern(regexp = "(?=.*[a-z])(?=.*[0-9])(?=.*[!/?@])[a-zA-Z0-9!/" + "?@]{8,20}$",
        message = "password는 소문자, 숫자, 특수문자가 포함되어야 하며 8자 이상 20자 이하여야 합니다.")
    var password: String,

    @field:NotBlank(message = "name은 Null, 공백, 띄어쓰기를 허용하지 않습니다.")
    @field:Size(max = 5, message = "name은 5자 이하여야 합니다.")
    var name: String,

    @field:NotNull
    @field:Length(max = 3, message = "3자리 숫자가 넘어가선 안됩니다.")
    val age: Int,
)