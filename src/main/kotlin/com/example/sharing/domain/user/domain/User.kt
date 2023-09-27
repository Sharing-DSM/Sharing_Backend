package com.example.sharing.domain.user.domain

import com.example.sharing.global.entity.BaseUUIDEntity
import org.hibernate.annotations.DynamicInsert
import org.hibernate.validator.constraints.Length
import java.util.*
import javax.persistence.Entity
import javax.validation.constraints.NotNull

@Entity(name = "tbl_user")
@DynamicInsert
class User(
    override val id: UUID,

    @field:NotNull
    @field:Length(max = 15)
    val accountId: String,

    @field:NotNull
    @field:Length(max = 60)
    val password: String,

    @field:NotNull
    @field:Length(max = 6)
    val name: String,

    @field:NotNull
    @field:Length(max = 3)
    val age: Int,

    @field:Length(max = 2000)
    val profile: String?,
) : BaseUUIDEntity()