package com.rutubishi.data.repository

import com.rutubishi.testUtils.AppRepositoryTest
import com.rutubishi.testUtils.sampleUserData
import kotlin.test.Test

class AuthRepoTest : AppRepositoryTest() {
    override fun repo() = AuthRepoImpl(appDatabase)

    @Test
    fun `when user is created then it should be returned`() {
        val user = repo().createUser(
            name = sampleUserData.name,
            email = sampleUserData.email,
            phone = sampleUserData.phone,
            password = sampleUserData.password
        )
        assert(user != null)
    }

    @Test
    fun `when user is searched by id or email then it should be returned`(){
        val appRepo = repo()
        val user = appRepo.createUser(
            name = sampleUserData.name,
            email = sampleUserData.email,
            phone = sampleUserData.phone,
            password = sampleUserData.password
        )
        val userById = appRepo.findUserByIdOrEmail(
            id = user?.id?.value,
            email = null
        )
        val userByEmail = appRepo.findUserByIdOrEmail(
            id = null,
            email = user?.email
        )
        assert(userById != null)
        assert(userByEmail != null)
    }

}
