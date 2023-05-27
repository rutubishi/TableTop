package com.rutubishi.data.db

import com.rutubishi.testUtils.sampleUser
import com.rutubishi.testUtils.testAppDB
import org.jetbrains.exposed.exceptions.ExposedSQLException
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.properties.Delegates
import kotlin.test.assertEquals
import kotlin.test.assertFailsWith
import kotlin.test.expect

class UserEntityTest {

    private var count by Delegates.notNull<Long>()

    @Before
    fun setUp(){
        count = 0
    }

    @After
    fun tearDown(){
        transaction(testAppDB) {
            User.all().forEach { it.delete() }
        }
    }

    @Test
    fun `given valid user data adds to DB correctly`() {
        transaction(testAppDB) {
            sampleUser()
            sampleUser(email = "x@mail.com", phone = "1234591")
            count = User.all().count()
        }
        expect(2) { count }
    }

    @Test
    @Throws(Exception::class)
    fun `given same data for user fails with index exception`() {
        assertFailsWith<ExposedSQLException>(
            message = "Unique index or primary key violation") {
            transaction(testAppDB) {
                sampleUser()
                sampleUser()
                count = User.all().count()
            }
        }
        assertEquals(0, count)
    }

}