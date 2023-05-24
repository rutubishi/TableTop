package com.rutubishi.plugins

import com.apurebase.kgraphql.GraphQL
import io.ktor.server.application.*

fun Application.configureGraphQL() {
    install(GraphQL){
        endpoint = "/graphql"
        playground = true
        schema {
            query("hello") {
                resolver { -> "world" }
            }
        }
    }
}