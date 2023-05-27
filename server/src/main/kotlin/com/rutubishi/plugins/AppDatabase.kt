package com.rutubishi.plugins

import com.rutubishi.data.db.TableTopDBFactory
import com.zaxxer.hikari.HikariDataSource

fun configureDB() {
    val dataSource: HikariDataSource = HikariDataSource().apply {
        driverClassName = "org.postgresql.Driver"
        jdbcUrl = "jdbc:postgresql://localhost:5432/tableTop?user=postgres&password=postgres"
        maximumPoolSize = 5
        isAutoCommit = true
        transactionIsolation = "TRANSACTION_REPEATABLE_READ"
        validate()
    }
    TableTopDBFactory.init(dataSource = dataSource)
}