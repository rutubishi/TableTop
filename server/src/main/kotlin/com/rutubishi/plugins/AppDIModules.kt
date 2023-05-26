package com.rutubishi.plugins

import com.rutubishi.di.appModule
import io.ktor.server.application.*
import org.koin.ktor.plugin.Koin

fun Application.configureDI(){
    install(Koin) {
        modules(
            listOf(
                appModule,
            )
        )
    }
}