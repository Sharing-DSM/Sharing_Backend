package com.example.sharing.domain.user.presentation

import com.example.sharing.domain.user.presentation.dto.request.UpdateUserInfoRequest
import com.example.sharing.domain.user.presentation.dto.request.UserLoginRequest
import com.example.sharing.domain.user.presentation.dto.request.UserSignUpRequest
import com.example.sharing.domain.user.presentation.dto.response.QueryUserResponse
import com.example.sharing.domain.user.presentation.dto.response.TokenResponse
import com.example.sharing.domain.user.presentation.dto.response.UploadProfileResponse
import com.example.sharing.domain.user.service.QueryUserService
import com.example.sharing.domain.user.service.SetInterestAreaService
import com.example.sharing.domain.user.service.UpdateUserInfoService
import com.example.sharing.domain.user.service.UploadProfileService
import com.example.sharing.domain.user.service.UserLoginService
import com.example.sharing.domain.user.service.UserSignUpService
import com.example.sharing.domain.user.service.UserTokenRefreshService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import org.springframework.web.multipart.MultipartFile
import java.util.*
import javax.validation.Valid

@RequestMapping("/users")
@RestController
class UserController(
    private val userSignUpService: UserSignUpService,
    private val userLoginService: UserLoginService,
    private val setInterestAreaService: SetInterestAreaService,
    private val queryUserService: QueryUserService,
    private val updateUserInfoService: UpdateUserInfoService,
    private val uploadProfileService: UploadProfileService,
    private val tokenRefreshService: UserTokenRefreshService,
) {
    @ResponseStatus(CREATED)
    @PostMapping("/signup")
    fun signUp(@RequestBody @Valid request: UserSignUpRequest) {
        userSignUpService.execute(request)
    }

    @PostMapping("/login")
    fun login(@RequestBody @Valid request: UserLoginRequest): TokenResponse {
        return userLoginService.execute(request)
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping
    fun setInterestArea(@RequestParam("interest-area") interestArea: String) {
        setInterestAreaService.execute(interestArea)
    }

    @GetMapping
    fun queryUser(): QueryUserResponse = queryUserService.execute()

    @ResponseStatus(NO_CONTENT)
    @PatchMapping
    fun updateUserInfo(@RequestBody @Valid request: UpdateUserInfoRequest) = updateUserInfoService.execute(request)

    @PostMapping("/upload")
    fun uploadProfile(@RequestPart(name = "profile") file: MultipartFile): UploadProfileResponse {
        return uploadProfileService.execute(file)
    }

    @PutMapping("/reissue")
    fun tokenReissue(@RequestHeader("Authorization") refreshToken: String): TokenResponse {
        return tokenRefreshService.execute(refreshToken)
    }
}