package com.rutubishi.data.db

import com.zaxxer.hikari.HikariDataSource
import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction

object TableTopDBFactory {
    val schemas:Array<Table> = arrayOf(
        Users
    );
    fun init(dataSource: HikariDataSource): Database {
        val db = Database.connect(datasource = dataSource)
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(*schemas)
        }
        return db;
    }
}
