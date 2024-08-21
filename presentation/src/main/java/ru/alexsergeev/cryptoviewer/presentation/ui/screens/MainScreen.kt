package ru.alexsergeev.cryptoviewer.presentation.ui.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.Divider
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import androidx.lifecycle.compose.collectAsStateWithLifecycle
import androidx.navigation.NavController
import com.google.accompanist.swiperefresh.SwipeRefresh
import com.google.accompanist.swiperefresh.rememberSwipeRefreshState
import kotlinx.coroutines.ExperimentalCoroutinesApi
import org.koin.androidx.compose.koinViewModel
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.states.CoinsViewState
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoCoinItem
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoTopBar
import ru.alexsergeev.cryptoviewer.presentation.ui.components.ErrorSnackBar
import ru.alexsergeev.cryptoviewer.presentation.utils.NetworkConnectionState
import ru.alexsergeev.cryptoviewer.presentation.utils.rememberConnectivityState
import ru.alexsergeev.cryptoviewer.presentation.viewmodel.MainScreenViewModel


@OptIn(ExperimentalCoroutinesApi::class)
@Composable
internal fun MainScreen(
    navController: NavController,
    viewModel: MainScreenViewModel = koinViewModel(),
) {

    val uiState = viewModel.uiState.collectAsStateWithLifecycle(CoinsViewState.Loading)

    val isLoading by viewModel.isLoading().collectAsStateWithLifecycle()
    val swipeRefreshState = rememberSwipeRefreshState(isRefreshing = isLoading)

    val connectionState by rememberConnectivityState()
    val isConnected by remember(connectionState) {
        derivedStateOf { connectionState === NetworkConnectionState.Available }
    }

    Column(modifier = Modifier.padding(horizontal = 4.dp)) {
        CryptoTopBar(stringResource(id = R.string.coins_list))
        Divider(thickness = 1.5.dp)
        when (val current = uiState.value) {
            is CoinsViewState.Loading -> Box(
                modifier = Modifier
                    .fillMaxSize(),
                contentAlignment = Alignment.Center
            ) {
                CircularProgressIndicator(
                    progress = 0.75f,
                    color = CryptoTheme.colors.activeComponent
                )
            }

            is CoinsViewState.Success -> SwipeRefresh(
                state = swipeRefreshState,
                onRefresh = {
                    viewModel.loadStuffAfterSwipe()
                },
            ) {
                LazyColumn {
                    current.coins.forEach {
                        item {
                            CryptoCoinItem(it) {
                                navController.navigate("detail_screen/${it.id}/${it.name}")
                            }
                        }
                    }
                }

            }

            is CoinsViewState.Error -> ErrorScreen {
                viewModel.loadCoinsList()
            }

        }
    }
    if (viewModel.errorLoadingCoins().collectAsStateWithLifecycle().value || !isConnected) {
        ErrorSnackBar()
    }
}