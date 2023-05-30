package com.rutubishi.graphql.mutations

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.rutubishi.services.AuthService
import kotlinx.serialization.Serializable

class AuthMutation(
    private val authService: AuthService
): AbstractMutation() {

    override fun register(schemaBuilder: SchemaBuilder) {
        super.register(schemaBuilder)
        signUp()
        signIn()
    }

    override fun registerTypes() {
        builder.type(AuthOutput::class){
            name = "Authentication"
            description = "Registration / Login response"
        }
        builder.type(SignInInput::class) {
            name = "SignInInput"
            description = "Input for sign in"
        }
        builder.type(SignUpInput::class) {
            name = "SignUpInput"
            description = "Input for sign up"
        }
    }

    private fun signUp() =
        builder.
            mutation("signUp") {
                resolver { signUp: SignUpInput ->
                    authService.createAccount(
                        signUp.email,
                        signUp.fullName,
                        signUp.phone,
                        signUp.password
                    )
                }
            }

    private fun signIn() =
        builder.
            mutation("signIn") {
                resolver { signIn: SignInInput ->
                    authService.loginAccount(
                        signIn.email,
                        signIn.password
                    )
                }
            }


    companion object {
        @Serializable
        data class AuthOutput(
            val token: String?
        )

        @Serializable
        data class SignInInput(
            val email: String,
            val password: String
        )

        @Serializable
        data class SignUpInput(
            val email: String,
            val fullName: String,
            val phone: String,
            val password: String
        )

    }

}