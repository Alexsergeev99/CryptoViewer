package ru.alexsergeev.cryptoviewer.data.di

import org.koin.core.module.dsl.singleOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.cryptoviewer.data.repository.MainRepositoryImpl
import ru.alexsergeev.cryptoviewer.domain.repository.MainRepository

val dataModule = module {
    singleOf(::MainRepositoryImpl) bind MainRepository::class
}