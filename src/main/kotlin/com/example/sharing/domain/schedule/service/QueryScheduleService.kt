package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.schedule.domain.repository.ScheduleRepository
import com.example.sharing.domain.schedule.presentation.dto.response.QueryScheduleResponse
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class QueryScheduleService(
    private val scheduleRepository: ScheduleRepository,
    private val userFacade: UserFacade
) {
    @Transactional(readOnly = true)
    fun execute(): QueryScheduleResponse {
        val user = userFacade.getCurrentUser()
        return QueryScheduleResponse(scheduleRepository.findAllByUserAndIsCompleted(user, false))
    }
}