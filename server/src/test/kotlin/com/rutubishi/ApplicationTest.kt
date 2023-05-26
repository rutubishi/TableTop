package com.rutubishi

import com.rutubishi.data.db.User
import com.rutubishi.data.repository.AuthRepository
import org.junit.After
import org.junit.Before
import org.junit.Test
import kotlin.test.expect

class ApplicationTest {

    val authRepo: AuthRepository = TestAuthRepo()

    @Before
    fun setUp(){

    }

    @After
    fun tearDown(){

    }

    @Test
    fun insertUser(){
        expect(null){
            authRepo.createUser(
                name = "test",
                email = "",
                phone = "",
                password = ""
            )
        }
    }

}

class TestAuthRepo: AuthRepository{
    override fun createUser(name: String, email: String, phone: String, password: String): User? {
        return if(name == "test" && email == ""){
            null
        } else User[0]
    }

    override fun findUserByIdOrEmail(id: Long?, email: String?): User? {
        TODO("Not yet implemented")
    }

}
