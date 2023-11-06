package com.example.sharing.domain.schedule.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.*
import javax.validation.constraints.NotNull

@Entity(name = "tbl_schedule")
@DynamicInsert
class Schedule (
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotNull
    @field:Length(max = 10)
    val title: String,

    @field:NotNull
    val year: String,

    @field:NotNull
    val month: String,

    @field:NotNull
    val day: String
)