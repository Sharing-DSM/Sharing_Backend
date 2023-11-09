package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.feed.exception.NotValidUserException
import com.example.sharing.domain.schedule.facade.ScheduleFacade
import com.example.sharing.domain.schedule.presentation.dto.request.UpdateScheduleRequest
import com.example.sharing.domain.user.domain.User
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UpdateScheduleService(
    val userFacade: UserFacade,
    val scheduleFacade: ScheduleFacade,
) {
    @Transactional
    fun execute(scheduleId: UUID, request: UpdateScheduleRequest) {
        val user: User = userFacade.getCurrentUser()
        val schedule = scheduleFacade.getById(scheduleId)

        if (user.id != schedule.user.id) {
            throw NotValidUserException.EXCEPTION
        }

        schedule.updateSchedule(request.title, request.date)
    }
}