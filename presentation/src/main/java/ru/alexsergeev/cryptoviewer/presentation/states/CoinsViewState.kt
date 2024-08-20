package ru.alexsergeev.cryptoviewer.presentation.states

import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel

internal sealed class CoinsViewState {
    data object Loading : CoinsViewState()
    data class Success(val coins: List<CoinUiModel>) : CoinsViewState()
    data class Error(val message: String) : CoinsViewState()
}