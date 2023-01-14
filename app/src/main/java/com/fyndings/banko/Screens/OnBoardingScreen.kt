package com.fyndings.banko.Screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.material.Icon
import androidx.compose.material.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Alignment.Companion.CenterHorizontally
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavHostController
import com.fyndings.banko.R
import com.fyndings.banko.Screen
import com.fyndings.banko.ui.theme.Black
import com.fyndings.banko.ui.theme.ClaspoNDTypography
import com.fyndings.banko.ui.theme.White

//@Preview(showBackground = true)
@Composable
fun OnBoardingScreen(navController: NavHostController) {
    Box(modifier = Modifier
        .background(White)
        .fillMaxSize()) {
        Column {
            Logo()
            Spacer(modifier = Modifier.height(60.dp))
            Tagline()
            Spacer(modifier = Modifier.height(120.dp))
            Icon(
                painter = painterResource(id = R.drawable.ic_play), contentDescription = "Start",
                modifier = Modifier
                    .align(CenterHorizontally)
                    .size(100.dp)
                    .clickable { navController.navigate(Screen.HomeScreen.route) },
            )
        }
    }
}

//@Preview
@Composable
fun Logo() {
    Column(
        modifier = Modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally) {
        Image(painter = painterResource(id = R.drawable.ic_drop_logo),
            contentDescription = null,
            modifier = Modifier
                .padding(start = 50.dp, end = 50.dp, top = 50.dp)
                .size(150.dp))
        Text(text = "Banko", style = ClaspoNDTypography.h1,
            color = Black,
            fontSize = 45.sp, textAlign = TextAlign.Center,
            modifier = Modifier
                .fillMaxWidth()
                .padding())
    }
}

@Preview(showBackground = true)
@Composable
fun Tagline() {
    Column(
        horizontalAlignment = Alignment.Start, modifier = Modifier
            .fillMaxWidth()
            .padding(horizontal = 15.dp)) {
        Text(text = "Easy banking",
            fontSize = 40.sp,
            style = ClaspoNDTypography.h1)
        Text(text = "with simple",
            fontSize = 40.sp,
            style = ClaspoNDTypography.h1)
        Text(text = "way", fontSize = 40.sp, style = ClaspoNDTypography.h1)
    }
}
