package com.rutubishi.plugins

import com.apurebase.kgraphql.GraphQL
import com.apurebase.kgraphql.KGraphQL
import com.rutubishi.data.db.TableTopDBFactory
import com.rutubishi.data.db.User
import com.rutubishi.graphql.mutations.AuthMutation
import com.rutubishi.graphql.mutations.BaseMutation
import io.ktor.server.application.*
import org.jetbrains.exposed.sql.transactions.transaction
import org.koin.ktor.ext.inject

fun Application.configureGraphQL() {
    val authMutation: AuthMutation by inject()
    install(GraphQL){
        endpoint = "/graphql"
        playground = true
        schema {
            authMutation::register.invoke()
        }
    }
}

//internal fun Application.registerMutations(){
//
//    val mutations = arrayOf<BaseMutation>(
//        authMutation
//    )
//    mutations.map {
//        it.register()
//    }
//}