package ru.alexsergeev.cryptoviewer

import android.app.Application
import org.koin.android.ext.koin.androidContext
import org.koin.android.ext.koin.androidLogger
import org.koin.core.context.startKoin
import ru.alexsergeev.cryptoviewer.data.di.dataModule
import ru.alexsergeev.cryptoviewer.domain.di.domainModule
import ru.alexsergeev.cryptoviewer.presentation.di.presentationModule

class App : Application() {
    override fun onCreate() {
        super.onCreate()

        startKoin {
            androidLogger()
            androidContext(this@App)
            modules(listOf(presentationModule, domainModule, dataModule))
        }
    }
}