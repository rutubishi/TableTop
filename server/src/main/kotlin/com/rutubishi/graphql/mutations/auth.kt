package com.rutubishi.graphql.mutations

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.rutubishi.common.data.graphql.models.*
import com.rutubishi.common.data.network.ResponseStatus
import com.rutubishi.services.AuthService

class AuthMutation(
    private val authService: AuthService
): AbstractMutation() {

    override fun register(schemaBuilder: SchemaBuilder) {
        super.register(schemaBuilder)
        signUp()
        signIn()
        createAccount()
        testQuery()
    }

    override fun registerTypes() {
        builder.type(AuthOutput::class){
            name = "Authentication"
            description = "Registration / Login response"
        }
        builder.inputType(SignInInput::class) {
            name = "SignInInput"
            description = "Input for sign in"
        }
        builder.inputType(SignUpInput::class) {
            name = "SignUpInput"
            description = "Input for sign up"
        }
        builder.type(TestOutput::class){
            name = "TestOutput"
            description = "Test output"
        }
        builder.type(ResponseStatus::class){
            name = "ResponseStatus"
            description = "Response status"
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

    private fun createAccount() =
        builder.
            mutation("createUserAccount") {
                resolver { signUp: SignUpInput ->
                    "${authService.registerAccount(
                        signUp.email,
                        signUp.fullName,
                        signUp.phone,
                        signUp.password
                    )}"
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

    private fun testQuery() =
        builder.
            query("test") {
                resolver { ->
                    TestOutput("Hello welcome to GraphQL")
                }
            }

}