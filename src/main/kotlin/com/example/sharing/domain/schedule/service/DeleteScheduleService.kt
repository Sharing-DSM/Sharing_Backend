package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.chat.exception.InvalidUserException
import com.example.sharing.domain.schedule.domain.repository.ScheduleRepository
import com.example.sharing.domain.schedule.facade.ScheduleFacade
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeleteScheduleService (
    private val scheduleRepository: ScheduleRepository,
    private val scheduleFacade: ScheduleFacade,
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(scheduleId: UUID) {
        val user = userFacade.getCurrentUser()
        val schedule = scheduleFacade.getById(scheduleId)

        if(user.id != schedule.user.id) {
            throw InvalidUserException.EXCEPTION
        }

        scheduleRepository.deleteById(scheduleId)

    }
}