package com.example.sharing.domain.schedule.presentation.dto.response

import com.example.sharing.domain.schedule.presentation.dto.ScheduleElement

data class QueryScheduleResponse(
    val scheduleList: List<ScheduleElement>
)