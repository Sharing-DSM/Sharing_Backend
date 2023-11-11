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
import javax.persistence.OneToOne

@Entity(name = "tbl_private_room")
@DynamicInsert
class PrivateRoom(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    userA: User,
    userB: User,
    room: Room
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userA_id", columnDefinition = "BINARY(16)", nullable = false)
    var userA = userA
        protected  set

    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "userB_id", columnDefinition = "BINARY(16)", nullable = false)
    var userB = userB
        protected  set

    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "room_id", columnDefinition = "BINARY(16)", nullable = false)
    var room = room
        protected  set
}