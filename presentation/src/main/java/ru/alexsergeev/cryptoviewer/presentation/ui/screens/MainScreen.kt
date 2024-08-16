package ru.alexsergeev.cryptoviewer.presentation.ui.screens

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoCoinItem
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoTopBar

@Composable
fun MainScreen() {
    Column(modifier = Modifier.padding(horizontal = 4.dp)) {
        CryptoTopBar("Список криптовалют")
        Divider(thickness = 1.5.dp)
        LazyColumn {
            items(5) {
                CryptoCoinItem("Bitcoin", "BTC", "$ 28,600.74")
            }
            items(5) {
                CryptoCoinItem("Ethereum", "ETH", "$ 2,600.74")
            }
            items(5) {
                CryptoCoinItem("Binance", "BNB", "$ 432.69")
            }
        }
    }
}