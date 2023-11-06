package com.example.sharing.domain.schedule.domain

import com.example.sharing.domain.user.domain.User
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
    var title: String,

    @field:NotNull
    var year: String,

    @field:NotNull
    var month: String,

    @field:NotNull
    var day: String,

    user: User
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected  set

    fun updateSchedule(title: String, year: String, month: String, day: String) {
        this.title = title
        this.year = year
        this.month = month
        this.day = day
    }
}