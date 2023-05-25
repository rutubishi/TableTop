package com.rutubishi.services

import com.auth0.jwt.JWT
import com.auth0.jwt.algorithms.Algorithm
import com.rutubishi.data.db.User
import com.rutubishi.data.db.Users
import com.rutubishi.data.repository.AuthRepository
import com.toxicbakery.bcrypt.Bcrypt
import io.ktor.server.application.*
import io.ktor.server.auth.*
import io.ktor.server.auth.jwt.*
import io.ktor.server.response.*
import io.ktor.server.routing.*
import org.jetbrains.exposed.sql.transactions.transaction
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
    ) {
        transaction {
            val user = User.new {
                this.email = email
                this.name = fullName
                this.phone = phone
                this.passwordHash = hashPass(password)
            }
        }
    }

    @Throws(Exception::class)
    fun loginAccount(
        email: String,
        password: String,
    ): Boolean {
        var user: User? = null
        transaction {
            user = User
                .find { Users.email eq email }
                .limit(n = 1)
                .firstOrNull()
        }
        return if(user == null) false
        else isCorrectPass(hash = user?.passwordHash!!, password = password)
    }

    private fun hashPass(password: String): String =
        Bcrypt.hash(password, SALT_ROUNDS).toString()

    private fun isCorrectPass(hash: String, password: String): Boolean =
        Bcrypt.verify(password, hash.toByteArray())

    private fun encodeJWT(userData: Pair<String, Int>): String {
        return JWT.create()
            .withClaim("userdata", userData.toList().toMutableList())
            .withExpiresAt(
                Date(System.currentTimeMillis() + 6000))
            .sign(Algorithm.HMAC256(JWT_SECRET))
    }

    private fun decodeJWT(token: String): Pair<String, Int>{
        return TODO()
    }

    companion object {
        // setup JWT configuration
        fun Application.configureJWT() {
            authentication {
                jwt {
                    val jwtAudience = this@configureJWT.environment.config.property("jwt.audience").getString()
                    realm = this@configureJWT.environment.config.property("jwt.realm").getString()
                    verifier(JWT
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