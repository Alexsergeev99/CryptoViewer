package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.cryptoviewer.presentation.models.CoinUiModel
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.AdaLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.AtomLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.BinanceLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.BitcoinLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.EthLogo
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.XrpLogo
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.MainScreenViewModel

@Composable
internal fun CryptoCoinItem(
    coin: CoinUiModel,
    viewModel: MainScreenViewModel = koinViewModel(),
    goToCoinDetailScreen: () -> Unit = {}
) {

    val showInDollars = viewModel.showInDollars().collectAsStateWithLifecycle().value

    Card(
        modifier = Modifier
            .fillMaxWidth()
            .padding(8.dp)
            .clickable {
                goToCoinDetailScreen()
            },
        colors = CardDefaults.cardColors(Color.Transparent)
    ) {
        Row(
            modifier = Modifier
                .fillMaxSize()
                .padding(vertical = 1.dp),
            verticalAlignment = Alignment.CenterVertically,
            horizontalArrangement = Arrangement.SpaceBetween
        ) {
            Row(
                verticalAlignment = Alignment.CenterVertically,
            ) {
                when (coin.ticker) {
                    "BTC" -> BitcoinLogo()
                    "ETH" -> EthLogo()
                    "ADA" -> AdaLogo()
                    "ATOM" -> AtomLogo()
                    "BNB" -> BinanceLogo()
                    else -> XrpLogo()
                }
                Column(
                    modifier = Modifier
                        .padding(4.dp),
                    verticalArrangement = Arrangement.Center
                ) {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = coin.title,
                        color = Color.Black,
                        style = CryptoTheme.typography.heading2
                    )
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = coin.ticker,
                        color = CryptoTheme.colors.subheadingText,
                        style = CryptoTheme.typography.heading2
                    )
                }
            }
            Column(
                modifier = Modifier
                    .padding(4.dp),
                verticalArrangement = Arrangement.Center,
                horizontalAlignment = Alignment.End
            ) {
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = if(showInDollars) coin.priceUSD else coin.priceRUB,
                    color = Color.Black,
                    style = CryptoTheme.typography.heading2
                )
                Text(
                    modifier = Modifier.padding(2.dp),
                    text = "+ 4.05%",
                    color = CryptoTheme.colors.goodNewsColor,
                    style = CryptoTheme.typography.heading2,
                )
            }
        }
    }
}