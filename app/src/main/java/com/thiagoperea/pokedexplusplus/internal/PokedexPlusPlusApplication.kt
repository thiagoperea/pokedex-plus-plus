package com.thiagoperea.pokedexplusplus.internal

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin

class PokedexPlusPlusApplication : Application() {

    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@PokedexPlusPlusApplication)
            modules(appModule)
        }
    }
}