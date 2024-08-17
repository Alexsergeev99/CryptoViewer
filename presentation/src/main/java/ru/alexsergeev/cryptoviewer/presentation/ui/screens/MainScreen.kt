package ru.alexsergeev.cryptoviewer.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.cryptoviewer.presentation.mock.coins
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoCoinItem
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoTopBar

@Composable
internal fun MainScreen(navController: NavController) {
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
