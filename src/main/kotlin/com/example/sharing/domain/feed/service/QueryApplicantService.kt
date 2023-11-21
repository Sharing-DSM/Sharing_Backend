package com.example.sharing.domain.feed.service

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.domain.repository.ApplyRepository
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional
import java.util.*

@Service
class QueryApplicantService(
    private val applyRepository: ApplyRepository
) {
    @Transactional(readOnly = true)
    fun execute(feedId: UUID): List<Apply> {
        return applyRepository.findAllByFeedId(feedId)
    }
}