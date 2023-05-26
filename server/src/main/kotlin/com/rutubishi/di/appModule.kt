package com.rutubishi.di

import com.rutubishi.data.repository.AuthRepoImpl
import com.rutubishi.data.repository.AuthRepository
import com.rutubishi.graphql.mutations.AuthMutation
import com.rutubishi.services.AuthService
import org.koin.dsl.module

val appModule = module {
    single <AuthRepository> { AuthRepoImpl() }
    single { AuthService(get()) }
    single { AuthMutation(get()) }
}