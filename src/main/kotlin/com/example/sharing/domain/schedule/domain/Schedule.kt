package com.example.sharing.domain.schedule.domain

<<<<<<< main
import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.time.LocalDate
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
=======
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.time.LocalDate
import java.util.*
import javax.persistence.*
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
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
<<<<<<< main
    var title: String,

    @field:NotNull
    var date: LocalDate,

    user: User
) {
    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected  set

    fun updateSchedule(title: String, date: LocalDate) {
        this.title = title
        this.date = date
    }
}
=======
    val title: String,

    @field:NotNull
<<<<<<< main
    val year: String,

    @field:NotNull
    val month: String,

    @field:NotNull
    val day: String
)
>>>>>>> ⚡️ :: 자원봉사 일정 추가 구현
=======
    val date: LocalDate
)
>>>>>>> ♻️ :: LocalDate 사용
