package com.example.sharing.domain.schedule.domain.repository

import com.example.sharing.domain.schedule.domain.Schedule
import com.example.sharing.domain.schedule.presentation.dto.ScheduleElement
import com.example.sharing.domain.user.domain.User
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ScheduleRepository: JpaRepository<Schedule, UUID> {
    fun findAllByUserAndIsCompleted(user: User, isCompleted: Boolean): List<ScheduleElement>
}