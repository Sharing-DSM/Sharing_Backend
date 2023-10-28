package com.example.sharing.domain.feed.presentation.dto.request

import javax.validation.constraints.NotBlank
<<<<<<< HEAD
=======
import javax.validation.constraints.NotNull
>>>>>>> feed-update
import javax.validation.constraints.Size

data class UpdateFeedRequest (
    @field:NotBlank(message = "title는 Null를 허용하지 않습니다.")
    @field:Size(max = 20, message = "title은 20자 이하여야 합니다.")
    var title: String,

    @field:NotBlank(message = "content는 Null를 허용하지 않습니다.")
    @field:Size(max = 2000, message = "content은 2000자 이하여야 합니다.")
    var content: String,

<<<<<<< HEAD
    @field:NotBlank(message = "recruitment는 Null를 허용하지 않습니다.")
    var recruitment: Int,

    @field:NotBlank(message = "volunteerTime는 Null를 허용하지 않습니다.")
=======
    @field:NotNull(message = "recruitment는 Null를 허용하지 않습니다.")
    var recruitment: Int,

    @field:NotNull(message = "volunteerTime는 Null를 허용하지 않습니다.")
>>>>>>> feed-update
    var volunteerTime: Int,
)