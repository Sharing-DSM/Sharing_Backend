package com.example.sharing.domain.feed.domain

import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne

@Entity(name = "tbl_apply")
@DynamicInsert
class Apply (
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    user: User,

    feed: Feed

) {

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BINARY(16)", nullable = false)
    var feed = feed

}