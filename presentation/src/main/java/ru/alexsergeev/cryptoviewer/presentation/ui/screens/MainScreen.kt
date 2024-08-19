package ru.alexsergeev.cryptoviewer.presentation.ui.screens

import android.util.Log
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import kotlinx.coroutines.flow.forEach
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.cryptoviewer.domain.models.CoinDomainModel
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoCoinItem
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoTopBar
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.MainScreenViewModel

@Composable
internal fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = koinViewModel()
) {

    val coins = viewModel.getCoinsList().collectAsStateWithLifecycle().value

    Column(modifier = Modifier.padding(horizontal = 4.dp)) {
        CryptoTopBar("Список криптовалют")
        Divider(thickness = 1.5.dp)
        LazyColumn {
            coins.forEach {
                item {
                    CryptoCoinItem(it) {
                        navController.navigate("detail_screen/${it.id}")
                    }
                }
            }
        }
    }
}
