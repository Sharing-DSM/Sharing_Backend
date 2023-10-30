package com.example.sharing.domain.feed.domain.repository

import com.example.sharing.domain.feed.domain.Tag
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface TagRepository : JpaRepository<Tag, UUID>