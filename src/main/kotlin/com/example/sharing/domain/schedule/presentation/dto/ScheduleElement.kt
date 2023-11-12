package com.example.sharing.domain.schedule.presentation.dto

import java.time.LocalDate
import java.util.*

data class ScheduleElement(
    val id: UUID,
    val title: String,
    val date: LocalDate,
    val isCompleted: Boolean,
)