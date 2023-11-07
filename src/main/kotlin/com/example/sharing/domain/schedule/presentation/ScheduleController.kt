package com.example.sharing.domain.schedule.presentation

import com.example.sharing.domain.schedule.presentation.dto.request.CreateScheduleRequest
<<<<<<< main
<<<<<<< main
import com.example.sharing.domain.schedule.presentation.dto.request.UpdateScheduleRequest
import com.example.sharing.domain.schedule.service.CreateScheduleService
import com.example.sharing.domain.schedule.service.UpdateScheduleService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import java.util.*
=======
=======
import com.example.sharing.domain.schedule.service.CheckScheduleService
>>>>>>> ⚡️ :: 자원봉사 일정 확인 구현
import com.example.sharing.domain.schedule.service.CreateScheduleService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
<<<<<<< main
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
=======
import java.util.*
>>>>>>> ⚡️ :: 자원봉사 일정 확인 구현
import javax.validation.Valid

@RequestMapping("/schedules")
@RestController
class ScheduleController (
    private val createScheduleService: CreateScheduleService,
<<<<<<< main
<<<<<<< main
    private val updateScheduleService: UpdateScheduleService,
) {
    @ResponseStatus(CREATED)
=======
) {
    @ResponseStatus(HttpStatus.CREATED)
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
=======
    private val checkScheduleService: CheckScheduleService,
) {
    @ResponseStatus(CREATED)
>>>>>>> ⚡️ :: 자원봉사 일정 확인 구현
    @PostMapping
    fun createSchedule(@RequestBody @Valid request: CreateScheduleRequest) {
        createScheduleService.execute(request)
    }
<<<<<<< main
<<<<<<< main

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/{schedule-id}")
    fun updateSchedule(@PathVariable ("schedule-id") scheduleId: UUID, @RequestBody @Valid request: UpdateScheduleRequest) {
        updateScheduleService.execute(scheduleId, request)
    }
=======
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
=======

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/check/{schedule-id}")
    fun checkSchedule(@PathVariable ("schedule-id") scheduleId: UUID) {
        checkScheduleService.execute(scheduleId)
    }
>>>>>>> ⚡️ :: 자원봉사 일정 확인 구현
}