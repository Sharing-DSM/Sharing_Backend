package com.example.sharing.domain.schedule.facade

import com.example.sharing.domain.feed.exception.FeedNotFoundException
import com.example.sharing.domain.schedule.domain.Schedule
import com.example.sharing.domain.schedule.domain.repository.ScheduleRepository
import org.springframework.stereotype.Component
import java.util.*

@Component
class ScheduleFacade(
    private val scheduleRepository: ScheduleRepository,
) {
    fun getById(scheduleId: UUID): Schedule {
        return scheduleRepository.findById(scheduleId)
            .orElseThrow { FeedNotFoundException.EXCEPTION }
    }
}