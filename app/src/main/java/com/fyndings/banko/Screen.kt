package com.fyndings.banko

sealed class Screen(val route: String) {
    object OnBoardingScreen : Screen("onboarding_screen")
    object HomeScreen : Screen("home_screen")
    object WalletScreen : Screen("wallet_screen")
    object ScanScreen : Screen("scan_screen")
    object BalanceScreen : Screen("balance_screen")
    object ProfileScreen : Screen("profile_screen")
}
