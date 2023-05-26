package com.rutubishi.graphql.mutations

import com.apurebase.kgraphql.KGraphQL.Companion.schema
import com.apurebase.kgraphql.schema.Schema
import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.rutubishi.services.AuthService

class AuthMutation(
    private val authService: AuthService
): BaseMutation {

    override fun register(): Array<() -> Schema> {
        return arrayOf(::signUp, ::signIn)
    }


    fun signUp() =
        schema {
            mutation("register") {
                resolver { email: String, fullName: String, phone: String, password: String ->
                    authService.createAccount(email, fullName, phone, password)
                }
            }
        }

    fun signIn() =
        schema {
            mutation("signIn") {
                resolver { email: String, password: String ->
                    authService.loginAccount(email, password)
                }
            }
        }


}