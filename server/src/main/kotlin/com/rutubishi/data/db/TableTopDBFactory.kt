package com.rutubishi.data.db

import org.jetbrains.exposed.sql.*
import org.jetbrains.exposed.sql.transactions.transaction
import javax.sql.DataSource

object TableTopDBFactory {
    private val schemas:Array<Table> = arrayOf(
        Users
    );
    fun init(dataSource: DataSource): Database {
        val db = Database.connect(datasource = dataSource)
        transaction {
            addLogger(StdOutSqlLogger)
            SchemaUtils.create(*schemas)
        }
        return db;
    }
}
