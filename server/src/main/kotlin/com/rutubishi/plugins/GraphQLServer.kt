package com.rutubishi.plugins

import com.apurebase.kgraphql.GraphQL
import com.rutubishi.data.db.TableTopDBFactory
import com.rutubishi.data.db.User
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.transactions.transaction

fun Application.configureGraphQL() {
    TableTopDBFactory.init()
    install(GraphQL){
        endpoint = "/graphql"
        playground = true
        schema {
            query("hello") {
                resolver { ->
                    sendSampleData()
                }
            }
        }
    }
}

fun sendSampleData(): String{
    val users = transaction {
        User.all().toList()
    }
    return "users.joinToString()"
}