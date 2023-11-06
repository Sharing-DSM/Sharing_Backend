package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Apply
import com.example.sharing.domain.feed.domain.ApplyId
import org.springframework.data.jpa.repository.JpaRepository

interface ApplyRepository: JpaRepository<Apply, ApplyId>