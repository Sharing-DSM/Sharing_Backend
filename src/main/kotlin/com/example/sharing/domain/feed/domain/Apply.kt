package com.example.sharing.domain.feed.domain

import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import javax.persistence.*

@Entity(name = "tbl_apply")
@DynamicInsert
class Apply (

    @EmbeddedId
    var id: ApplyId,

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