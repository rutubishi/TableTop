package com.rutubishi

import com.rutubishi.plugins.*
import com.rutubishi.services.AuthService.Companion.configureJWT
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureDI()
    configureDB()
    configureJWT()
    configureErrorHandler()
    configureRouting()
    configureGraphQL()
}
