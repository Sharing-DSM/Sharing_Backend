package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Apply
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface ApplyRepository: JpaRepository<Apply, UUID>