package com.fyndings.banko.ui.theme

import androidx.compose.material.Typography
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.fyndings.banko.R

// Set of Material typography styles to start with

val ClaspoND = FontFamily(
    Font(R.font.claspo_variable, FontWeight.Light),
    Font(R.font.claspo_regular, FontWeight.Normal),
    Font(R.font.claspo_medium, FontWeight.Medium),
    Font(R.font.claspo_semibold, FontWeight.SemiBold),
    Font(R.font.claspo_bold, FontWeight.Bold),
    Font(R.font.claspo_black, FontWeight.Black),
    Font(R.font.claspo_ultra, FontWeight.ExtraBold)
)

val ClaspoNDTypography = Typography(

    h1 = TextStyle(
        fontFamily = ClaspoND,
        fontWeight = FontWeight.Bold,
        fontSize = 30.sp
    ),
    h2 = TextStyle(
        fontFamily = ClaspoND,
        fontWeight = FontWeight.SemiBold,
        fontSize = 24.sp
    ),
    body1 = TextStyle(
        fontFamily = ClaspoND,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    body2 = TextStyle(
        fontFamily = ClaspoND,
        fontWeight = FontWeight.Thin,
        fontSize = 14.sp
    )
)


val Typography = Typography(
    body1 = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    )
    /* Other default text styles to override
    button = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.W500,
        fontSize = 14.sp
    ),
    caption = TextStyle(
        fontFamily = FontFamily.Default,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
    */
)