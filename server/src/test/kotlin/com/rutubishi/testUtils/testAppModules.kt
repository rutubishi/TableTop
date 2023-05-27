package com.rutubishi.testUtils

import org.jetbrains.exposed.sql.Database
import org.koin.dsl.module

val testAppModules = module {
    factory <Database> { testAppDB }
}