package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.schedule.domain.repository.ScheduleRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class DeleteScheduleService (
    private val scheduleRepository: ScheduleRepository,
) {
    @Transactional
    fun execute(id: UUID) {

        val schedule = scheduleRepository.findById(id)

        if (schedule != null) {
            scheduleRepository.deleteById(id)
        } else {
            throw IllegalArgumentException("schedule not found for ID: $id")
        }

    }
}