package com.example.sharing.domain.user.presentation

import com.example.sharing.domain.user.presentation.dto.request.UserLoginRequest
import com.example.sharing.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.sharing.domain.user.service.UserSignUpService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request: UserSignUpRequest) {
        userSignUpService.excute(request)
    }
}