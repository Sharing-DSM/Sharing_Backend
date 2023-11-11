package com.example.sharing.domain.chat.domain

import com.example.sharing.domain.chat.domain.type.RoomType
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import java.time.LocalDateTime
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id

@Entity(name = "tbl_room")
@DynamicInsert
class Room(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @Column(nullable = false)
    var roomType: RoomType,

    var lastText: String,

    @Column(columnDefinition = "DATETIME")
    var lastSendAt: LocalDateTime,
) {
    fun updateLastTextAndLastSendAt(lastText: String, lastSendAt: LocalDateTime) {
        this.lastText = lastText
        this.lastSendAt = lastSendAt
    }
}