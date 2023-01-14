package com.fyndings.banko

import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.fyndings.banko.Screens.*

@Composable
fun Navigation() {
    val navController = rememberNavController()
    NavHost(navController = navController, startDestination = Screen.OnBoardingScreen.route) {
        composable(route = Screen.OnBoardingScreen.route) {
            OnBoardingScreen(navController)
        }
        composable(route = Screen.HomeScreen.route) {
            HomeScreen(navController)
        }
        composable(route = Screen.WalletScreen.route) {
            WalletScreen(navController)
        }
        composable(route = Screen.ScanScreen.route) {
            ScanScreen(navController)
        }
        composable(route = Screen.BalanceScreen.route) {
            BalanceScreen(navController)
        }
        composable(route = Screen.ProfileScreen.route) {
            ProfileScreen(navController)
        }
    }
}