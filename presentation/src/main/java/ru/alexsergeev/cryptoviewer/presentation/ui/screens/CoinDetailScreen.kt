package ru.alexsergeev.cryptoviewer.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.states.CoinDetailViewState
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoTopBarMini
import ru.alexsergeev.cryptoviewer.presentation.ui.components.logotypes.CoinLogoBig
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.CoinDetailViewModel

@Composable
internal fun CoinDetailScreen(
    navController: NavController,
    id: String,
    name: String,
    viewModel: CoinDetailViewModel = koinViewModel()
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle(CoinDetailViewState.Loading)
    viewModel.loadCoin(id)

    Column(modifier = Modifier.padding(horizontal = 4.dp)) {
        CryptoTopBarMini(name) {
            navController.popBackStack()
        }
        Divider(thickness = 1.5.dp)
        when (val current = uiState.value) {
            is CoinDetailViewState.Loading -> Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    progress = 0.75f,
                    color = CryptoTheme.colors.activeComponent
                )
            }

            is CoinDetailViewState.Success -> LazyColumn {
                item {
                    Box(
                        modifier = Modifier
                            .fillMaxWidth()
                            .padding(vertical = 8.dp), contentAlignment = Alignment.Center
                    ) {
                        CoinLogoBig(image = current.coin.image)
                    }
                }
                item {
                    Text(
                        modifier = Modifier.padding(horizontal = 2.dp, vertical = 8.dp),
                        text = stringResource(id = R.string.description),
                        color = Color.Black,
                        style = CryptoTheme.typography.heading1
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(2.dp),
                        text = current.coin.info ?: "",
                        color = Color.Black,
                        style = CryptoTheme.typography.heading2
                    )
                }
                item {
                    Text(
                        modifier = Modifier.padding(horizontal = 2.dp, vertical = 8.dp),
                        text = stringResource(id = R.string.categories),
                        color = Color.Black,
                        style = CryptoTheme.typography.heading1
                    )
                }
                item {
                    current.coin.categories?.let {
                        Text(
                            modifier = Modifier.padding(2.dp),
                            text = it.joinToString(", "),
                            color = Color.Black,
                            style = CryptoTheme.typography.heading2
                        )
                    }
                }
            }

            is CoinDetailViewState.Error -> {
                ErrorScreen {
                    viewModel.loadCoin(id)
                }
            }
        }
    }
}