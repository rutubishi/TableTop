package com.rutubishi.services

import at.favre.lib.crypto.bcrypt.BCrypt
import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.rutubishi.common.data.graphql.models.AuthOutput
import com.rutubishi.data.db.User
import com.rutubishi.data.repository.AuthRepository
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import java.util.*

class AuthService(
    private val authRepository: AuthRepository
) {

    @Throws(Exception::class)
    fun createAccount(
        email: String,
        fullName: String,
        phone: String,
        password: String
    ): AuthOutput {
        val user = authRepository
            .createUser(
                email = email,
                name = fullName,
                phone = phone,
                password = hashPass(password)
            )
        return AuthOutput(
            token = encodeJWT(Pair(email, user?.id?.value!!))
        )
    }

    @Throws(Exception::class)
    fun loginAccount(
        email: String,
        password: String,
    ): AuthOutput {
        val user: User? = authRepository
            .findUserByIdOrEmail(
                email = email
            )
        print("id: ${user?.id}, email: ${user?.email}")
        return if(user == null) AuthOutput(token = null)
        else if(!isCorrectPass(hash = user.passwordHash, password = password))
            AuthOutput(token = null)
        else AuthOutput(
            token = encodeJWT(Pair(email, user.id.value))
        )
    }

    private fun hashPass(password: String): String =
        BCrypt
            .withDefaults()
            .hashToString(SALT_ROUNDS, password.toCharArray())

    private fun isCorrectPass(hash: String, password: String): Boolean =
        BCrypt
            .verifyer()
            .verify(password.toCharArray(), hash)
            .verified

    private fun encodeJWT(userData: Pair<String, Long>): String {
        return JWT
            .create()
            .withClaim("userdata", userData.toList().toMutableList())
            .withExpiresAt(
                Date(System.currentTimeMillis() + 6000))
            .sign(Algorithm.HMAC256(JWT_SECRET))
    }

    private fun decodeJWT(token: String): Pair<String, Int>{
        return JWT
            .decode(token)
            .getClaim("userdata")
            .asList(Any::class.java).apply {
                if(this.size != 2) throw Exception("Invalid token")
            }.let {
                Pair(it[0].toString(), it[1].toString().toInt())
            }
    }

    companion object {
        // setup JWT configuration
        fun Application.configureJWT() {
            authentication {
                jwt {
                    val jwtAudience = this@configureJWT.environment.config.property("jwt.audience").getString()
                    realm = this@configureJWT.environment.config.property("jwt.realm").getString()
                    verifier(
                        JWT
                            .require(Algorithm.HMAC256(JWT_SECRET))
                            .withAudience(jwtAudience)
                            .withIssuer(this@configureJWT.environment.config.property("jwt.domain").getString())
                            .build()
                    )
                    validate { credential ->
                        if (credential.payload.audience.contains(jwtAudience))
                            JWTPrincipal(credential.payload)
                        else
                            null
                    }
                }
            }
        }

        // salt rounds
        private const val SALT_ROUNDS = 5

        // .env vars
        val JWT_SECRET: String = System.getenv("JWT_SECRET")

    }

}
