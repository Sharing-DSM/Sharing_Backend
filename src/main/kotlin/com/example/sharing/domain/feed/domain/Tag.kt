package com.example.sharing.domain.feed.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.FetchType.*
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.persistence.JoinColumn
import javax.persistence.ManyToOne
import javax.validation.constraints.NotBlank

@Entity(name = "tbl_tag")
@DynamicInsert
class Tag(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotBlank
    @field:Length(max = 10)
    val name: String,

    feed: Feed,
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "feed_id", columnDefinition = "BINARY(16)", nullable = false)
    var feed = feed
        protected  set
}