package com.rutubishi.plugins

import com.rutubishi.data.db.TableTopDBFactory
import io.ktor.server.application.*

fun Application.configureDB(){
    TableTopDBFactory.init()
}