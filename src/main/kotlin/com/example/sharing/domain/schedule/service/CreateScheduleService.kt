package com.example.sharing.domain.schedule.service

import com.example.sharing.domain.schedule.domain.Schedule
import com.example.sharing.domain.schedule.domain.repository.ScheduleRepository
import com.example.sharing.domain.schedule.presentation.dto.request.CreateScheduleRequest
import com.example.sharing.domain.user.facade.UserFacade
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.time.LocalDate
import java.util.*

@Service
class CreateScheduleService (
    private val scheduleRepository: ScheduleRepository,
<<<<<<< main
<<<<<<< main
=======
>>>>>>> ⚡️ :: 자원봉사 일정 확인 구현
    private val userFacade: UserFacade,
) {
    @Transactional
    fun execute(request: CreateScheduleRequest) {
        val user = userFacade.getCurrentUser()
<<<<<<< main
=======
) {
    @Transactional
    fun execute(request: CreateScheduleRequest) {
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
=======
>>>>>>> ⚡️ :: 자원봉사 일정 확인 구현
        scheduleRepository.save(
            Schedule(
                id = UUID.randomUUID(),
                title = request.title,
<<<<<<< main
<<<<<<< main
                date = request.date,
                user = user
=======
                year = request.year,
                month = request.month,
                day = request.day
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
=======
                date = LocalDate.of(
                    request.year.toInt(),
                    request.month.toInt(),
                    request.day.toInt()
<<<<<<< main
                )
>>>>>>> ♻️ :: LocalDate 사용
=======
                ),
                check = false,
                user = user
>>>>>>> ⚡️ :: 자원봉사 일정 확인 구현
            )
        )
    }
}