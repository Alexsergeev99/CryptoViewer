package ru.alexsergeev.cryptoviewer.domain.di

import org.koin.core.module.dsl.factoryOf
import org.koin.dsl.bind
import org.koin.dsl.module
import ru.alexsergeev.cryptoviewer.domain.usecase.implementation.GetCoinsListUseCaseImpl
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinUseCase
import ru.alexsergeev.cryptoviewer.domain.usecase.implementation.GetCoinUseCaseImpl
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinsListUseCase

val domainModule = module {
    factoryOf(::GetCoinsListUseCaseImpl) bind GetCoinsListUseCase::class
    factoryOf(::GetCoinUseCaseImpl) bind GetCoinUseCase::class
}