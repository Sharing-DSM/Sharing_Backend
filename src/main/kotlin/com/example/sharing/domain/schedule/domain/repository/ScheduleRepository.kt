package com.example.sharing.domain.schedule.domain.repository

import com.example.sharing.domain.schedule.domain.Schedule
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ScheduleRepository: JpaRepository<Schedule, UUID>