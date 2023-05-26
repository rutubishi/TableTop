package com.rutubishi.graphql.mutations

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.rutubishi.services.AuthService

class AuthMutation(
    private val authService: AuthService
): AbstractMutation() {

    override fun register(schemaBuilder: SchemaBuilder) {
        super.register(schemaBuilder)
        signUp()
        signIn()
    }


    private fun signUp() =
        builder.
            mutation("register") {
                resolver { email: String, fullName: String, phone: String, password: String ->
                    "authService.createAccount($email, $fullName, $phone, $password)"
                }
            }


    private fun signIn() =
        builder.
            mutation("signIn") {
                resolver { email: String, password: String ->
                    "email: $email, password: $password"
                }
            }



}