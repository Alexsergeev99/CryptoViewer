package ru.alexsergeev.cryptoviewer.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoTopBarMini
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.AdaLogoBig
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.AtomLogoBig
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.BinanceLogoBig
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.BitcoinLogoBig
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.EthLogoBig
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.XrpLogoBig
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.CoinDetailViewModel
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.MainScreenViewModel

@Composable
internal fun CoinDetailScreen(
    navController: NavController,
    id: String,
    viewModel: CoinDetailViewModel = koinViewModel()
) {

    val coin = viewModel.getCoin(id.toLong()).collectAsStateWithLifecycle().value

    Column(modifier = Modifier.padding(horizontal = 4.dp)) {
        CryptoTopBarMini(coin.title) {
            navController.navigateUp()
        }
        Divider(thickness = 1.5.dp)
        LazyColumn {
            item {
                Box(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(vertical = 8.dp), contentAlignment = Alignment.Center
                ) {
                    when (coin.ticker) {
                        "BTC" -> BitcoinLogoBig()
                        "ETH" -> EthLogoBig()
                        "ADA" -> AdaLogoBig()
                        "ATOM" -> AtomLogoBig()
                        "BNB" -> BinanceLogoBig()
                        else -> XrpLogoBig()
                    }
                }
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 8.dp),
                    text = "Описание",
                    color = Color.Black,
                    style = CryptoTheme.typography.heading1
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = coin.info,
                    color = Color.Black,
                    style = CryptoTheme.typography.heading2
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(horizontal = 2.dp, vertical = 8.dp),
                    text = "Категории",
                    color = Color.Black,
                    style = CryptoTheme.typography.heading1
                )
            }
            item {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = coin.categories.toString(),
                    color = Color.Black,
                    style = CryptoTheme.typography.heading2
                )
            }
        }
    }
}