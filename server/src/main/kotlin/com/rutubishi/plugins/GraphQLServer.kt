package com.rutubishi.plugins

import com.apurebase.kgraphql.GraphQL
import com.rutubishi.graphql.mutations.AuthMutation
import com.rutubishi.graphql.mutations.BaseMutation
import io.ktor.server.application.*
import org.koin.ktor.ext.inject

fun Application.configureGraphQL() {
    install(GraphQL){
//        useDefaultPrettyPrinter = true
        endpoint = "/graphql"
        playground = true
        schema {
            /**
            * Mutations - Write operations
            * */
            mutations().forEach {
                it.register(this)
            }
            /**
             * Queries - Read operations
             * */

            /**
             * Subscriptions - Realtime operations
             * */

            /**
             * Types - Custom types
             * */

        }
    }
}

internal fun Application.mutations(): Array<BaseMutation> {
    val authMutation: AuthMutation by inject()
    return arrayOf(
        authMutation
    )
}
