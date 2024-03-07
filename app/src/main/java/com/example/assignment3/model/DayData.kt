package com.example.assignment3.model

import androidx.annotation.DrawableRes
import androidx.annotation.StringRes

data class DayData(
    val dayText: String,
    @DrawableRes val spriteResourceId: Int,
    @StringRes val titleId: Int,
    @DrawableRes val imageResourceId: Int,
    @StringRes val contentId: Int
    )
