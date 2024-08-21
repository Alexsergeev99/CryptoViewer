package ru.alexsergeev.cryptoviewer.presentation.viewmodel

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import ru.alexsergeev.cryptoviewer.domain.usecase.interfaces.GetCoinsListUseCase
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.states.CoinsViewState
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

    private val isLoadingMutable = MutableStateFlow(false)
    private val isLoading = isLoadingMutable.asStateFlow()

    private val errorLoadingCoinsMutable = MutableStateFlow<Boolean>(false)
    private val errorLoadingCoins: StateFlow<Boolean> = errorLoadingCoinsMutable

    private val _uiState = MutableStateFlow<CoinsViewState>(CoinsViewState.Loading)
    val uiState = _uiState.asStateFlow()


    init {
        getCoinsListFlow()
        getCoinsListFlowRubles()
    }

    private fun getCoinsListFlow(vsCurrency: String = "usd") {
        viewModelScope.launch {
            _uiState.value = CoinsViewState.Loading
            delay(1000)
            try {
                val coinsFlow = getCoinsListUseCase.invoke(vsCurrency)
                coinsFlow.collect { coins ->
                    coins.forEach { coin ->
                        coinsMutable.update {
                            (it + domainCoinToUiCoinMapper.map(coin)).toMutableList()
                        }
                    }
                }
                if (coins.value.isEmpty()) {
                    _uiState.value = CoinsViewState.Error("Exception")
                } else {
                    _uiState.value = CoinsViewState.Success(coins.value)
                }
            } catch (e: Exception) {
                _uiState.value = CoinsViewState.Error("Exception")
            }
        }
    }

    private fun getCoinsListFlowRubles(vsCurrency: String = "rub") {
        viewModelScope.launch {
            try {
                val coinsFlow = getCoinsListUseCase.invoke(vsCurrency)
                coinsFlow.collect { coins ->
                    coins.forEach { coin ->
                        coinsWithRublesPriceMutable.update {
                            (it + domainCoinToUiCoinMapper.map(coin)).toMutableList()
                        }
                    }
                }
            } catch (e: Exception) {
                throw e
            }
        }
    }

    private fun changeLoadingCoinsStatus() {
        errorLoadingCoinsMutable.update { true }
    }

    fun loadStuffAfterSwipe() {
        try {
            viewModelScope.launch {
                isLoadingMutable.value = true
                delay(2000L)
                getCoinsListFlow()
                isLoadingMutable.value = false
            }
        } catch (e: Exception) {
            changeLoadingCoinsStatus()
        }
    }

    fun loadCoinsList() = getCoinsListFlow()

    fun getCoinsWithPriceInRublesList(): StateFlow<List<CoinUiModel>> = coinsWithRublesPrice

    fun showInDollars(): StateFlow<Boolean> = showInDollars

    fun showInRubles(): StateFlow<Boolean> = showInRubles
    fun errorLoadingCoins(): StateFlow<Boolean> = errorLoadingCoins
    fun isLoading() = isLoading

    fun changeChipState() {
        showInDollarsMutable.value = !showInDollarsMutable.value
        showInRublesMutable.value = !showInRublesMutable.value
    }
}