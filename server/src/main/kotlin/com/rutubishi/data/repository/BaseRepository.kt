package com.rutubishi.data.repository

import org.jetbrains.exposed.sql.Database
import org.jetbrains.exposed.sql.transactions.experimental.newSuspendedTransaction
import org.jetbrains.exposed.sql.transactions.transaction
import kotlin.coroutines.CoroutineContext

abstract class BaseRepository(
    private val appDB: Database
) {
    protected fun <T> dbQuery(block: () -> T): T =
        transaction(appDB) {
            block()
        }

    protected suspend fun <T> dbQueryAsync(
        coroutineContext: CoroutineContext? = null,
        block: () -> T): T =
            newSuspendedTransaction(
                context = coroutineContext,
                appDB
            ) {
                block()
            }



}