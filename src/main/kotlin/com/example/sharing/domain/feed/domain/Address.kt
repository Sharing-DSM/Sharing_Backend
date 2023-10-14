package com.example.sharing.domain.feed.domain

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
import javax.persistence.OneToOne
import javax.validation.constraints.NotNull

@Entity(name = "tbl_address")
@DynamicInsert
class Address(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotNull
    @field:Length(max = 100)
    val addressName: String,

    @field:NotNull
    @field:Length(max = 100)
    val roadAddressName: String,

    @field:NotNull
    @field:Length(max = 100)
    val x: String,

    @field:NotNull
    @field:Length(max = 100)
    val y: String,

    feed: Feed
) {
    @OneToOne(fetch = LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BINARY(16)", nullable = false)
    var feed = feed
        protected  set
}