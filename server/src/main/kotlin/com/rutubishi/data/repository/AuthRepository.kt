package com.rutubishi.data.repository

interface AuthRepository {
    fun createAccount(): Unit
    fun signINAccount(): Unit
}

internal class AuthRepoImpl: AuthRepository {
    override fun createAccount() {
        TODO("Not yet implemented")
    }

    override fun signINAccount() {
        TODO("Not yet implemented")
    }

}