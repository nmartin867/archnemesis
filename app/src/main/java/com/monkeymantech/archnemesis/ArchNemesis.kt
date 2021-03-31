package com.monkeymantech.archnemesis

import android.app.Application
import com.monkeymantech.archnemesis.ioc.configuration
import com.monkeymantech.archnemesis.ioc.news
import org.koin.android.ext.koin.androidContext
import org.koin.core.context.startKoin

class ArchNemesis: Application() {
    override fun onCreate() {
        super.onCreate()
        startKoin {
            androidContext(this@ArchNemesis)
            modules(configuration, news)
        }
    }
}