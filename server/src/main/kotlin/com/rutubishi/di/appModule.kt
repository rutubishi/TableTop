package com.rutubishi.di

import com.rutubishi.data.db.TableTopDBFactory
import com.rutubishi.data.repository.AuthRepoImpl
import com.rutubishi.data.repository.AuthRepository
import com.rutubishi.graphql.mutations.AuthMutation
import com.rutubishi.services.AuthService
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module

val appModule = module {
    single <HikariDataSource> {
       HikariDataSource().apply {
                driverClassName = "org.postgresql.Driver"
                jdbcUrl = "jdbc:postgresql://localhost:5432/tableTop?user=postgres&password=postgres"
                maximumPoolSize = 5
                isAutoCommit = true
                transactionIsolation = "TRANSACTION_REPEATABLE_READ"
                validate()
       }
    }
    single <Database> { TableTopDBFactory.init(dataSource = get()) }
    single <AuthRepository> { AuthRepoImpl(appDB = get()) }
    single { AuthService(get()) }
    single { AuthMutation(get()) }
    single { Application(get())}
}