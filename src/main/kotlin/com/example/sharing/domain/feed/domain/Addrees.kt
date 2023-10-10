package com.example.sharing.domain.feed.domain

import com.example.sharing.domain.feed.domain.Feed
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.LAZY
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotNull

@Entity(name = "tbl_address")
@DynamicInsert
class Addrees(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotNull
    @field:Length(max = 100)
    val roadAddrees: String,

    @field:NotNull
    @field:Length(max = 100)
    val x: String,

    @field:NotNull
    @field:Length(max = 100)
    val y: String,

    feed: Feed
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BINARY(16)", nullable = false)
    var feed = feed
        protected  set
}