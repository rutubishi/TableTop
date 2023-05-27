package com.rutubishi.data.db

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.properties.Delegates
import kotlin.test.assertFailsWith
import kotlin.test.expect

class UserEntityTest {
    private val appDatabase: Database = TableTopDBFactory.init(
        dataSource = HikariDataSource().apply {
            driverClassName = "org.h2.Driver"
            jdbcUrl = "jdbc:h2:mem:test;DB_CLOSE_DELAY=-1"
        }
    )

    private var count by Delegates.notNull<Long>()
    private var user: User? = null

    private fun sampleUser(
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

    @Before
    fun setUp(){
        count = 0
    }

    @After
    fun tearDown(){
        transaction(appDatabase) {
            User.all().forEach { it.delete() }
        }
        user = null
    }

    @Test
    fun `add user successfully`() {
        transaction(appDatabase) {
            sampleUser()
            sampleUser(email = "x@mail.com", phone = "1234591")
            count = User.all().count()
        }
        expect(2) { count }
    }

    @Test
    @Throws(Exception::class)
    fun `do not add users with duplicate credentials`() {
        assertFailsWith<ExposedSQLException> {
            transaction(appDatabase) {
                sampleUser()
                sampleUser()
            }
        }
    }






}