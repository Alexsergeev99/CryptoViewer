package ru.alexsergeev.cryptoviewer.data.di

import org.koin.android.ext.koin.androidContext
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.cryptoviewer.data.api.provideApiService
import ru.alexsergeev.cryptoviewer.data.api.provideOkHttpClient
import ru.alexsergeev.cryptoviewer.data.api.provideRetrofit
import ru.alexsergeev.cryptoviewer.data.db.AppDb.Companion.buildDatabase
import ru.alexsergeev.cryptoviewer.data.db.AppDb.Companion.provideDao
import ru.alexsergeev.cryptoviewer.data.repository.MainRepositoryImpl
import ru.alexsergeev.cryptoviewer.data.utils.DataCoinToDomainCoinMapper
import ru.alexsergeev.cryptoviewer.data.utils.DataCoinDetailToDomainCoinMapper
import ru.alexsergeev.cryptoviewer.data.utils.DomainCoinToEntityCoinMapper
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository


val dataModule = module {
    singleOf(::MainRepositoryImpl) bind MainRepository::class

    single { provideOkHttpClient() }
    single { provideRetrofit(get()) }
    single { provideApiService(get()) }
    single { buildDatabase(androidContext()) }
    single { provideDao(get()) }

    singleOf(::DataCoinToDomainCoinMapper)
    singleOf(::DataCoinDetailToDomainCoinMapper)
    singleOf(::DomainCoinToEntityCoinMapper)

}



