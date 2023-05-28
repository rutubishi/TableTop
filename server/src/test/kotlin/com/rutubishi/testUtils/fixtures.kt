package com.rutubishi.testUtils

import com.rutubishi.data.db.TableTopDBFactory
import com.rutubishi.data.db.User
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database


data class SampleUser(
    val email: String = "sample@email.com",
    val name: String = "sample",
    val phone: String = "1234567890",
    val password: String = "password"
)

val sampleUserData = SampleUser()

fun sampleUser(
    email: String = sampleUserData.email,
    name: String = sampleUserData.name,
    phone: String = sampleUserData.phone,
    passwordHash: String = sampleUserData.password
) {
    User.new {
        this.email = email
        this.name = name
        this.phone = phone
        this.passwordHash = passwordHash
    }
}

val testAppDB: Database = TableTopDBFactory.init(
    dataSource = HikariDataSource().apply {
        driverClassName = "org.h2.Driver"
        jdbcUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
    }
)
