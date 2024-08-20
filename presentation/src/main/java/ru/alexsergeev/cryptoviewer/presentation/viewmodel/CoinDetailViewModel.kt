package ru.alexsergeev.cryptoviewer.presentation.viewmodel

import android.util.Log
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinUseCase
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.states.CoinDetailViewState
import ru.alexsergeev.cryptoviewer.presentation.states.CoinsViewState
import ru.alexsergeev.cryptoviewer.presentation.utils.DomainCoinToUiCoinMapper

internal class CoinDetailViewModel(
    private val getCoinUseCase: GetCoinUseCase,
    private val domainCoinToUiCoinMapper: DomainCoinToUiCoinMapper
) : ViewModel() {

    private val _uiState = MutableStateFlow<CoinDetailViewState>(CoinDetailViewState.Loading)

    private val coinMutable =
        MutableStateFlow<CoinUiModel>(CoinUiModel("0", "", "", "", 0, 0, "", listOf()))
    private val coin: StateFlow<CoinUiModel> = coinMutable
    val uiState = _uiState.asStateFlow()


    private fun getCoin(id: String): StateFlow<CoinUiModel> {
        if (coinMutable.value.name == "") {
            viewModelScope.launch {
                _uiState.value = CoinDetailViewState.Loading
                delay(1000)
                try {
                    val coinFlow = getCoinUseCase.invoke(id)
                    coinFlow.collect { coin ->
                        coinMutable.update { domainCoinToUiCoinMapper.map(coin) }
                    }
                    if (coin.value.name == "") {
                        _uiState.value = CoinDetailViewState.Error("Exception")
                    } else {
                        _uiState.value = CoinDetailViewState.Success(coin.value)
                    }
                } catch (e: Exception) {
                    _uiState.value = CoinDetailViewState.Error("Exception")
                }
            }
        }
        return coin
    }

    fun load(id: String) = getCoin(id)
}