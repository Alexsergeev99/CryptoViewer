package ru.alexsergeev.cryptoviewer.presentation.di

import org.koin.androidx.viewmodel.dsl.viewModelOf
import org.koin.core.module.dsl.singleOf
import org.koin.dsl.module
import ru.alexsergeev.cryptoviewer.presentation.utils.DomainCoinToUiCoinMapper
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.CoinDetailViewModel
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.MainScreenViewModel

val presentationModule = module {
    viewModelOf(::MainScreenViewModel)
    viewModelOf(::CoinDetailViewModel)

    singleOf(::DomainCoinToUiCoinMapper)
}