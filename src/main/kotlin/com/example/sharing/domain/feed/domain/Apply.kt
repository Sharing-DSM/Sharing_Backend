package com.example.sharing.domain.feed.domain

import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import javax.persistence.*

@Entity(name = "tbl_apply")
@DynamicInsert
class Apply (

    @EmbeddedId
    var id: ApplyId,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user: User,

    @ManyToOne(fetch = FetchType.LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BINARY(16)", nullable = false)
    var feed: Feed

) {
    fun apply(user: User, feed: Feed, id: ApplyId = ApplyId(user.id, feed.id)) {
        this.id = id
        this.user = user
        this.feed = feed

    }

}