package com.fyndings.banko

import android.annotation.SuppressLint
import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material.MaterialTheme
import androidx.compose.material.Scaffold
import androidx.compose.material.Surface
import androidx.compose.ui.Modifier
import androidx.navigation.compose.rememberNavController
import com.fyndings.banko.Models.BottomMenuItem
import com.fyndings.banko.Screens.BottomMenu
import com.fyndings.banko.Screens.HomeScreen
import com.fyndings.banko.Screens.OnBoardingScreen
import com.fyndings.banko.ui.theme.BankoTheme

class MainActivity : ComponentActivity() {
    @SuppressLint("UnusedMaterialScaffoldPaddingParameter")
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            BankoTheme {
                Navigation()
            }
        }
    }
}
