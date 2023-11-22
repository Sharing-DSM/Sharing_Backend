package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.schedule.domain.repository.ScheduleRepository
import com.example.sharing.domain.schedule.presentation.dto.response.QueryScheduleResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate

@Service
class QueryMonthlyScheduleService(
    private val scheduleRepository: ScheduleRepository,
    private val userFacade: UserFacade,
) {

    @Transactional(readOnly = true)
    fun execute(month: Int): QueryScheduleResponse {
        val user = userFacade.getCurrentUser()
        val schedules = scheduleRepository.findByUserAndCompletedAndDateIsAfter(user, false, LocalDate.now())
        return QueryScheduleResponse(schedules)
    }
}