package ru.alexsergeev.cryptoviewer.presentation.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import ru.alexsergeev.cryptoviewer.presentation.ui.screens.CoinDetailScreen
import ru.alexsergeev.cryptoviewer.presentation.ui.screens.MainScreen

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(
        navController = navController,
        startDestination = "main_screen"
    ) {
        composable("main_screen") {
            MainScreen(navController = navController)
        }
        composable("detail_screen/{id}") {
            CoinDetailScreen(
                navController = navController,
                it.arguments?.getString("id") ?: throw Exception()
            )
        }
    }
}