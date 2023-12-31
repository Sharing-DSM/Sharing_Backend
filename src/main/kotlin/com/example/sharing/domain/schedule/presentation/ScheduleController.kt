package com.example.sharing.domain.schedule.presentation

import com.example.sharing.domain.schedule.presentation.dto.request.CreateScheduleRequest
import com.example.sharing.domain.schedule.presentation.dto.request.UpdateIsCompletedRequest
import com.example.sharing.domain.schedule.presentation.dto.request.UpdateScheduleRequest
import com.example.sharing.domain.schedule.presentation.dto.response.QueryIsCompletedScheduleResponse
import com.example.sharing.domain.schedule.presentation.dto.response.QueryScheduleResponse
import com.example.sharing.domain.schedule.service.CreateScheduleService
import com.example.sharing.domain.schedule.service.DeleteScheduleService
import com.example.sharing.domain.schedule.service.QueryIsCompletedScheduleService
import com.example.sharing.domain.schedule.service.QueryMonthlyScheduleService
import com.example.sharing.domain.schedule.service.QueryScheduleService
import com.example.sharing.domain.schedule.service.UpdateIsCompletedService
import com.example.sharing.domain.schedule.service.UpdateScheduleService
import org.springframework.http.HttpStatus.*
import org.springframework.web.bind.annotation.*
import java.util.*
import javax.validation.Valid

@RequestMapping("/schedules")
@RestController
class ScheduleController (
    private val createScheduleService: CreateScheduleService,
    private val updateScheduleService: UpdateScheduleService,
    private val deleteScheduleService: DeleteScheduleService,
    private val queryIsCompletedScheduleService: QueryIsCompletedScheduleService,
    private val queryScheduleService: QueryScheduleService,
    private val updateIsCompletedService: UpdateIsCompletedService,
    private val queryMonthlyScheduleService: QueryMonthlyScheduleService,
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
    fun deleteSchedule(@PathVariable("schedule-id") scheduleId: UUID) {
        deleteScheduleService.execute(scheduleId)
    }

    @ResponseStatus(NO_CONTENT)
    @PutMapping("/check/{schedule-id}")
    fun checkSchedule(@PathVariable ("schedule-id") scheduleId: UUID, @RequestBody @Valid request: UpdateIsCompletedRequest) {
        updateIsCompletedService.execute(scheduleId, request)
    }

    @GetMapping("/is-completed")
    fun queryIsCompletedSchedules(): QueryIsCompletedScheduleResponse {
        return queryIsCompletedScheduleService.execute()
    }

    @GetMapping
    fun querySchedules(): QueryScheduleResponse {
        return queryScheduleService.execute()
    }

    @GetMapping("/monthly")
    fun queryMonthlySchedule(@RequestParam("month") month: Int): QueryScheduleResponse {
        return queryMonthlyScheduleService.execute(month)
    }
}