package com.example.sharing.domain.user.presentation

import com.example.sharing.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.sharing.domain.user.service.UserSignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping
@RestController
class UserController(
    private val userSignUpService: UserSignUpService
) {

    // 회원가입
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody request: UserSignUpRequest?): String {
        return userSignUpService.signUp(request)
    }
}