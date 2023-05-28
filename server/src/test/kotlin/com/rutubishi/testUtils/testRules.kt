package com.rutubishi.testUtils

import com.rutubishi.data.db.TableTopDBFactory
import com.rutubishi.data.repository.BaseRepository
import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.SchemaUtils
import org.jetbrains.exposed.sql.transactions.transaction
import org.junit.After
import org.junit.Before
import org.koin.core.context.startKoin
import org.koin.core.context.stopKoin
import org.koin.test.KoinTest
import org.koin.test.get


abstract class ServerTest : KoinTest {

    @Before
    open fun setUp() {
        startKoin {
            modules(listOf(testAppModules))
        }
    }

    @After
    open fun tearDown() {
        stopKoin()
    }

}
abstract class AppRepositoryTest: ServerTest() {
    lateinit var appDatabase: Database
    abstract fun repo(): BaseRepository

    override fun setUp() {
        super.setUp()
        appDatabase = get()
        transaction(appDatabase) {
            SchemaUtils.create(*TableTopDBFactory.schemas)
        }
    }

    override fun tearDown() {
        super.tearDown()
        transaction(appDatabase) {
            SchemaUtils.drop(*TableTopDBFactory.schemas)
        }
    }
}