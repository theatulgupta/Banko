package com.fyndings.banko.Models

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class Transaction(
    val merchantName: String,
    val type: String,
    val amount: String,
    val time: String,
    @DrawableRes val logo: Int,
    @ColorRes val color: Color,
)
