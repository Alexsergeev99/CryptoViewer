package ru.alexsergeev.cryptoviewer.presentation.states

import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel

internal sealed class CoinDetailViewState {
    data object Loading : CoinDetailViewState()
    data class Success(val coin: CoinUiModel) : CoinDetailViewState()
    data class Error(val message: String) : CoinDetailViewState()
}