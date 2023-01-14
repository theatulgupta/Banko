package com.fyndings.banko.Screens

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.fyndings.banko.ui.theme.White

@Composable
fun ProfileScreen(navController: NavHostController) {
    Box(
        modifier = Modifier
            .background(color = White)
            .fillMaxSize(),
    ) {
        DefaultText(name = "Profile")
        BottomMenu(
            navController = navController,
            menuItems = bottomMenuList,
            modifier = Modifier.align(Alignment.BottomCenter), onItemClick = {
                navController.navigate(it.route)
            }
        )
    }
}
