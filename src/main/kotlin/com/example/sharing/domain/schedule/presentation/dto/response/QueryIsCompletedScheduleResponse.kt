package com.example.sharing.domain.schedule.presentation.dto.response

import com.example.sharing.domain.schedule.presentation.dto.ScheduleElement

data class QueryIsCompletedScheduleResponse(
    val scheduleList: List<ScheduleElement>
)