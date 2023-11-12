package com.example.sharing.domain.user.domain

import org.hibernate.annotations.DynamicInsert
import org.hibernate.annotations.GenericGenerator
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Column
import javax.persistence.Entity
import javax.persistence.GeneratedValue
import javax.persistence.Id
import javax.validation.constraints.NotNull

@Entity(name = "tbl_user")
@DynamicInsert
class User(
    @Id
    @GeneratedValue(generator = "uuid4")
    @GenericGenerator(name = "uuid4", strategy = "org.hibernate.id.UUIDGenerator")
    @Column(columnDefinition = "BINARY(16)")
    val id: UUID,

    @field:NotNull
    @field:Length(max = 15)
    var accountId: String,

    @field:NotNull
    @field:Length(max = 60)
    var password: String,

    @field:NotNull
    @field:Length(max = 6)
    var name: String,

    @field:NotNull
    var age: Int,

    var interestArea: String?,

    @field:Length(max = 2000)
    var profile: String?,
) {
    fun updateInterestArea(interestArea: String) {
        this.interestArea = interestArea
    }

    fun updateUserInfo(accountId: String, name: String, age: Int) {
        this.accountId = accountId
        this.name = name
        this.age = age
    }
}
