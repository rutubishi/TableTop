package com.rutubishi.testUtils

import com.rutubishi.data.db.TableTopDBFactory
import com.rutubishi.data.db.User
import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.Database

fun sampleUser(
    email: String = "sample@email.com",
    name: String = "sample",
    phone: String = "1234567890",
    passwordHash: String = "password"
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
