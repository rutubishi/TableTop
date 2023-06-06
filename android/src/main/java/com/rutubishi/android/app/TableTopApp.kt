package com.rutubishi.android.app

import android.app.Application
import com.rutubishi.common.di.CommonModule
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class TableTopApp : Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidLogger()
            androidContext(this@TableTopApp)
            modules(CommonModule)
        }
    }
}