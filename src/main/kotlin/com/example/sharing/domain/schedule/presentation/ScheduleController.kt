package com.example.sharing.domain.schedule.presentation

import com.example.sharing.domain.schedule.presentation.dto.request.CreateScheduleRequest
import com.example.sharing.domain.schedule.service.CreateScheduleService
import org.springframework.http.HttpStatus
import org.springframework.web.bind.annotation.*
import javax.validation.Valid

@RequestMapping("/schedules")
@RestController
class ScheduleController (
    private val createScheduleService: CreateScheduleService,
) {
    @ResponseStatus(HttpStatus.CREATED)
    @PostMapping
    fun createSchedule(@RequestBody @Valid request: CreateScheduleRequest) {
        createScheduleService.execute(request)
    }
}