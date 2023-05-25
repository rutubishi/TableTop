package com.rutubishi.data.db

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object TableTopDBFactory {
    private val schemas:Array<Table> = arrayOf(
        Users
    );
    fun init(): Database {

        val dataSource: HikariDataSource = HikariDataSource().apply {
            driverClassName = "org.postgresql.Driver"
            jdbcUrl = "jdbc:postgresql://localhost:5432/tableTop?user=postgres&password=postgres"
            maximumPoolSize = 5
            isAutoCommit = true
            transactionIsolation = "TRANSACTION_REPEATABLE_READ"
            validate()
        }

        val db = Database.connect(datasource = dataSource)
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(*schemas)
        }

        return db;
    }
}
