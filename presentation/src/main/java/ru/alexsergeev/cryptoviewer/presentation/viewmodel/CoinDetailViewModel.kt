package ru.alexsergeev.cryptoviewer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinUseCase
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.utils.DomainCoinToUiCoinMapper

internal class CoinDetailViewModel(
    private val getCoinUseCase: GetCoinUseCase,
    private val domainCoinToUiCoinMapper: DomainCoinToUiCoinMapper
) : ViewModel() {
    private val coinMutable =
        MutableStateFlow<CoinUiModel>(CoinUiModel("0", "", "", "", 0, 0, "", listOf()))
    private val coin: StateFlow<CoinUiModel> = coinMutable

    fun getCoin(id: String): StateFlow<CoinUiModel> {
        if (coinMutable.value.name == "") {
            try {
                viewModelScope.launch {
                    val coinFlow = getCoinUseCase.invoke(id)
                    coinFlow.collect { coin ->
                        coinMutable.update { domainCoinToUiCoinMapper.map(coin) }
                    }

                }
                return coin
            } catch (e: Exception) {
                throw e
            }
        }
        return coin
    }
}