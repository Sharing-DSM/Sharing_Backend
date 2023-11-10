package com.example.sharing.domain.chat.domain

import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_chat")
@DynamicInsert
class Chat(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @Column(columnDefinition = "VARCHAR(3000)", nullable = false)
    val text: String,

    user: User,
    room: Room,
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected set

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "room_id", columnDefinition = "BINARY(16)", nullable = false)
    var room = room
        protected  set
}