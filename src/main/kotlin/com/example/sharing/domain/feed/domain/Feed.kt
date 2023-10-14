package com.example.sharing.domain.feed.domain

import com.example.sharing.domain.feed.presentation.dto.request.FeedUpdateRequest
import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.util.UUID
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity(name = "tbl_feed")
@DynamicInsert
class Feed(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    var id: UUID,

    @field:NotNull
    @field:Length(max = 20)
    var title: String,

    @field:NotNull
    @field:Length(max = 2000)
    var content: String,

    @field:NotNull
    var recruitment: Int,

    @field:NotNull
    var volunteerTime: Int,

    @field:NotNull
    val views: Int,

    user: User
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected  set

    fun updateFeed(feedUpdateRequest: FeedUpdateRequest) {
        title = feedUpdateRequest.title
        content = feedUpdateRequest.content
        recruitment = feedUpdateRequest.recruitment
        volunteerTime = feedUpdateRequest.volunteerTime
    }
}