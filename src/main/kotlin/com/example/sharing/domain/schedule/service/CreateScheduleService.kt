package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.schedule.domain.Schedule
import com.example.sharing.domain.schedule.domain.repository.ScheduleRepository
import com.example.sharing.domain.schedule.presentation.dto.request.CreateScheduleRequest
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class CreateScheduleService (
    private val scheduleRepository: ScheduleRepository,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(request: CreateScheduleRequest) {
        val user = userFacade.getCurrentUser()
        scheduleRepository.save(
            Schedule(
                id = UUID.randomUUID(),
                title = request.title,
                date = request.date,
                user = user
            )
        )
    }
}