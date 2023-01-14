package com.fyndings.banko.Models

import androidx.annotation.ColorRes
import androidx.annotation.DrawableRes
import androidx.compose.ui.graphics.Color

data class HistoryItem(
    val title: String,
    val date: String,
    @DrawableRes val logo: Int,
    val amount: String,
    @ColorRes val color: Color,
)
