package com.rutubishi.data.db

import org.jetbrains.exposed.dao.LongEntity
import org.jetbrains.exposed.dao.LongEntityClass
import org.jetbrains.exposed.dao.id.EntityID
import org.jetbrains.exposed.dao.id.LongIdTable

/**
 * ENTITY = users
 * */
object Users : LongIdTable("users") {
    val name = varchar(name = "full_name", length = 255)
    val email = varchar(name = "email_address", length = 255)
        .uniqueIndex("email_identifier")
    val phone = varchar(name = "phone_number", length = 13)
        .uniqueIndex("phone_identifier")
        .nullable()
        .default(null)
    val password_hash = varchar(name = "credential_hash", length = 255)
    val active = bool("is_active")
        .default(false)
    val account_auth = enumeration<AccountAuthType>("account_auth_type")
        .default(AccountAuthType.EMAIL)
}

class User(id: EntityID<Long>): LongEntity(id) {
    companion object : LongEntityClass<User>(Users)
    var name by Users.name
    var email by Users.email
    var phone by Users.phone
    var passwordHash by Users.password_hash
    var active by Users.active
    var accountAuth by Users.account_auth
}

enum class AccountAuthType {
    EMAIL, GOOGLE
}
