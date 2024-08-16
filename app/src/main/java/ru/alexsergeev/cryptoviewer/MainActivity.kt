package ru.alexsergeev.cryptoviewer

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import ru.alexsergeev.cryptoviewer.presentation.ui.components.CryptoCoinItem
import ru.alexsergeev.cryptoviewer.presentation.ui.components.OneChip
import ru.alexsergeev.cryptoviewer.presentation.ui.components.TryElseButton
import ru.alexsergeev.cryptoviewer.presentation.ui.screens.MainScreen

class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
//        enableEdgeToEdge()
        setContent {
//            Column(
//                modifier = Modifier.fillMaxSize(),
//                horizontalAlignment = Alignment.CenterHorizontally,
//                verticalArrangement = Arrangement.Center
//            ) {
//                CryptoCoinItem()
//            }
            MainScreen()
        }
    }
}