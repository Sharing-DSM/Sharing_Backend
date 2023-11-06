package com.example.sharing.domain.schedule.presentation

import com.example.sharing.domain.schedule.presentation.dto.request.CreateScheduleRequest
import com.example.sharing.domain.schedule.presentation.dto.request.UpdateScheduleRequest
import com.example.sharing.domain.schedule.service.CreateScheduleService
import com.example.sharing.domain.schedule.service.DeleteScheduleService
import com.example.sharing.domain.schedule.service.UpdateScheduleService
import org.springframework.web.bind.annotation.*
import org.springframework.http.HttpStatus.*
import java.util.*
import javax.validation.Valid

@RequestMapping("/schedules")
@RestController
class ScheduleController (
    private val createScheduleService: CreateScheduleService,
    private val updateScheduleService: UpdateScheduleService,
    private val deleteScheduleService: DeleteScheduleService,
) {
    @ResponseStatus(CREATED)
    @PostMapping
    fun createSchedule(@RequestBody @Valid request: CreateScheduleRequest) {
        createScheduleService.execute(request)
    }

    @ResponseStatus(NO_CONTENT)
    @PatchMapping("/{schedule-id}")
    fun updateSchedule(@PathVariable ("schedule-id") scheduleId: UUID, @RequestBody @Valid request: UpdateScheduleRequest) {
        updateScheduleService.execute(scheduleId, request)
    }

    @ResponseStatus(NO_CONTENT)
    @DeleteMapping("/{schedule-id}")
    fun deleteSchedule(@PathVariable("schedule-id") id: UUID) {
        deleteScheduleService.execute(id)
    }
}