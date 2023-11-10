package com.example.sharing.domain.chat.domain

import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_room")
@DynamicInsert
class Room(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    userA: User,

    userB: User,

    var lastText: String?,

    var lastSendAt: LocalDateTime?,

    var lastReadAt: LocalDateTime?
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userA_id", columnDefinition = "BINARY(16)", nullable = false)
    var userA = userA
        protected  set

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userB_id", columnDefinition = "BINARY(16)", nullable = false)
    var userB = userB
        protected  set

    fun updateLastTextAndLastSendAt(lastText: String, lastSendAt: LocalDateTime, lastReadAt: LocalDateTime) {
        this.lastText = lastText
        this.lastSendAt = lastSendAt
        this.lastReadAt = lastReadAt
    }
}