package com.rutubishi

import com.rutubishi.plugins.configureDB
import com.rutubishi.plugins.configureDI
import com.rutubishi.plugins.configureGraphQL
import com.rutubishi.plugins.configureRouting
import com.rutubishi.services.AuthService.Companion.configureJWT
import io.ktor.server.application.*
import io.ktor.server.netty.*

fun main(args: Array<String>) = EngineMain.main(args)

fun Application.module() {
    configureDB()
    configureDI()
    configureJWT()
    configureRouting()
    configureGraphQL()
}
