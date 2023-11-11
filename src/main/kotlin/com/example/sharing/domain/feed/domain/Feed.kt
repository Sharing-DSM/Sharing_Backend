package com.example.sharing.domain.feed.domain

import com.example.sharing.domain.feed.domain.type.Type
import com.example.sharing.domain.user.domain.User
import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.EnumType
import javax.persistence.Enumerated
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
    var title: String,

    @field:NotBlank
    @field:Length(max = 2000)
    var content: String,

    @field:Length(max = 100)
    var addressName: String,

    @field:NotNull
    @field:Length(max = 100)
    var roadAddressName: String,

    @field:NotNull
    var x: Double,

    @field:NotNull
    var y: Double,

    @field:NotNull
    var recruitment: Int,

    @field:NotNull
    var volunteerTime: Int,

    @field:NotNull
    var views: Int,

    @field:NotNull
    var isEmergency: Boolean = false,

    type: Type,

    user: User
) {
    @ManyToOne(fetch = LAZY)
    @JoinColumn(name = "user_id", columnDefinition = "BINARY(16)", nullable = false)
    var user = user
        protected  set

    @field:NotNull
    @field:Enumerated(EnumType.STRING)
    var type = type
        protected set

    fun updateFeed(title: String, content: String, recruitment: Int, volunteerTime: Int, addressName: String, isEmergency: Boolean, roadAddressName: String, x: Double, y: Double, type: Type) {
        this.title = title
        this.content = content
        this.recruitment = recruitment
        this.volunteerTime = volunteerTime
        this.addressName = addressName
        this.roadAddressName = roadAddressName
        this.x = x
        this.y = y
        this.isEmergency = isEmergency
        this.type = type
    }
}