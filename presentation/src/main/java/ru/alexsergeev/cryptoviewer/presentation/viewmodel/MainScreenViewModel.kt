package ru.alexsergeev.cryptoviewer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinsListUseCase
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.utils.DomainCoinToUiCoinMapper

internal class MainScreenViewModel(
    private val getCoinsListUseCase: GetCoinsListUseCase,
    private val domainCoinToUiCoinMapper: DomainCoinToUiCoinMapper
) : ViewModel() {

    private val coinsMutable =
        MutableStateFlow<MutableList<CoinUiModel>>(mutableListOf())
    private val coins: StateFlow<List<CoinUiModel>> = coinsMutable

    private val coinsWithRublesPriceMutable =
        MutableStateFlow<MutableList<CoinUiModel>>(mutableListOf())
    private val coinsWithRublesPrice: StateFlow<List<CoinUiModel>> = coinsWithRublesPriceMutable

    private val showInDollarsMutable = MutableStateFlow<Boolean>(true)
    private val showInDollars: StateFlow<Boolean> = showInDollarsMutable

    private val showInRublesMutable = MutableStateFlow<Boolean>(false)
    private val showInRubles: StateFlow<Boolean> = showInRublesMutable

    init {
        getCoinsListFlow()
        getCoinsListFlowRubles()
    }

    private fun getCoinsListFlow(vsCurrency: String = "usd") {
        try {
            viewModelScope.launch {
                val coinsFlow = getCoinsListUseCase.invoke(vsCurrency)
                coinsFlow.collect { coins ->
                    coins.forEach { coin ->
                        coinsMutable.update {
                            (it + domainCoinToUiCoinMapper.map(coin)).toMutableList()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    private fun getCoinsListFlowRubles(vsCurrency: String = "rub") {
        try {
            viewModelScope.launch {
                val coinsFlow = getCoinsListUseCase.invoke(vsCurrency)
                coinsFlow.collect { coins ->
                    coins.forEach { coin ->
                        coinsWithRublesPriceMutable.update {
                            (it + domainCoinToUiCoinMapper.map(coin)).toMutableList()
                        }
                    }
                }
            }
        } catch (e: Exception) {
            throw e
        }
    }

    fun getCoinsList(): StateFlow<List<CoinUiModel>> = coins
    fun getCoinsWithPriceInRublesList(): StateFlow<List<CoinUiModel>> = coinsWithRublesPrice

    fun showInDollars(): StateFlow<Boolean> = showInDollars

    fun showInRubles(): StateFlow<Boolean> = showInRubles

    fun changeChipState() {
        showInDollarsMutable.value = !showInDollarsMutable.value
        showInRublesMutable.value = !showInRublesMutable.value
    }
}