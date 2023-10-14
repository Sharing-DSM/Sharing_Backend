package com.example.sharing.domain.feed.domain

import com.example.sharing.domain.user.domain.User
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
import javax.validation.constraints.NotNull

@Entity(name = "tbl_feed")
@DynamicInsert
class Feed(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotBlank
    @field:Length(max = 20)
    val title: String,

    @field:NotBlank
    @field:Length(max = 2000)
    val content: String,

    @field:NotNull
    @field:Length(max = 100)
    val addressName: String,

    @field:NotNull
    @field:Length(max = 100)
    val roadAddressName: String,

    @field:NotNull
    val x: Double,

    @field:NotNull
    val y: Double,

    @field:NotNull
    val recruitment: Int,

    @field:NotNull
    val volunteerTime: Int,

    @field:NotNull
    val views: Int,

    user: User
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected  set
}