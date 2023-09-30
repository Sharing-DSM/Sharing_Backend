package com.example.sharing.domain.user.presentation.dto.request

import org.hibernate.validator.constraints.Length
import javax.validation.constraints.NotNull

data class UserSignUpRequest (
    @field:NotNull
    @field:Length(max = 15, message = "15자까지 가능합니다")
    val accountId: String,

    @field:NotNull
    @field:Length(max = 60)
    val password: String,

    @field:NotNull
    @field:Length(max = 6)
    val name: String,

    @field:NotNull
    @field:Length(max = 3, message = "3자리 숫자가 넘어가선 안됩니다.")
    val age: Int,

    @field:Length(max = 2000)
    val profile: String?,
)