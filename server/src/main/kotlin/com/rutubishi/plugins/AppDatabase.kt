package com.rutubishi.plugins

import com.rutubishi.data.db.TableTopDBFactory
import com.zaxxer.hikari.HikariDataSource
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureDB() {
    val dataSource: HikariDataSource by inject()
    TableTopDBFactory.init(dataSource = dataSource)
}