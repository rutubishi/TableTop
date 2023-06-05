package com.rutubishi.graphql.mutations

import com.apurebase.kgraphql.schema.dsl.SchemaBuilder
import com.apurebase.kgraphql.schema.execution.GenericTypeResolver
import com.rutubishi.common.data.graphql.models.AuthOutput
import com.rutubishi.common.data.graphql.models.SignInInput
import com.rutubishi.common.data.graphql.models.SignUpInput
import com.rutubishi.common.data.graphql.models.TestOutput
import com.rutubishi.common.data.network.AppResponse
import com.rutubishi.services.AuthService
import kotlin.reflect.KType
import kotlin.reflect.typeOf

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
        builder.type(AppResponse::class) {
            name = "AppResponse"
            description = "Response for all requests"
        }
        builder.type(CheckX::class) {
            name = "AppResponse"
            description = "Response for all requests"
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

    private fun configure(){
        builder.configure {
            genericTypeResolver = AuthOutputResolver()
        }
    }

    data class CheckX(val x: String)

    class AuthOutputResolver : GenericTypeResolver {
        override fun resolveMonad(type: KType): KType {
            return typeOf<AppResponse<AuthOutput>>()
        }
        override fun unbox(obj: Any): Any? {
            TODO("Not yet implemented")
        }
    }

}