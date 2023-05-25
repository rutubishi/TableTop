package com.rutubishi

import com.rutubishi.plugins.configureDB
import com.rutubishi.plugins.configureGraphQL
import com.rutubishi.plugins.configureRouting
import io.ktor.server.application.*
import io.ktor.server.engine.*
import io.ktor.server.netty.*

fun main() {
    embeddedServer(Netty, port = 3000, host = "0.0.0.0", module = Application::module)
        .start(wait = true)
}

fun Application.module() {
    configureDB()
    configureRouting()
    configureGraphQL()
}
