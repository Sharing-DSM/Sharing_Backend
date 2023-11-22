package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.schedule.facade.ScheduleFacade
import com.example.sharing.domain.schedule.presentation.dto.request.UpdateIsCompletedRequest
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class UpdateIsCompletedService(
    val scheduleFacade: ScheduleFacade,
) {
    @Transactional
    fun execute(id: UUID, request: UpdateIsCompletedRequest) {
        val schedule = scheduleFacade.getById(id)
        schedule.updateIsCompleted(request.completed)
    }
}