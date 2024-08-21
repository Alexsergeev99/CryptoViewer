package ru.alexsergeev.cryptoviewer.presentation.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Snackbar
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.RectangleShape
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import ru.alexsergeev.cryptoviewer.presentation.R
import ru.alexsergeev.cryptoviewer.presentation.theme.CryptoTheme

@Composable
internal fun ErrorSnackBar() {
    Box(modifier = Modifier.fillMaxSize(), contentAlignment = Alignment.BottomCenter) {
        Snackbar(
            modifier = Modifier
                .padding(bottom = 8.dp)
                .width(328.dp)
                .height(48.dp),
            shape = RectangleShape,
            containerColor = CryptoTheme.colors.badNewsColor,
            contentColor = Color.White
        ) {
            Text(
                modifier = Modifier.padding(2.dp),
                text = stringResource(id = R.string.loading_error),
                color = Color.White,
                style = CryptoTheme.typography.metadata1
            )
        }
    }
}