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
    transaction {
        repeat(5){
            User.new {
                this.active = true
                this.email = "asdas"
                this.passwordHash = "adasdasd"
                this.phone = "sdasdas"
                this.name = "Adasdasdas"
            }
        }
        commit()
    }
    val users = transaction {
        User.all().toList()
    }

    return users.joinToString(",")
}