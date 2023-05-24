package com.rutubishi.common.ui.util

import androidx.compose.ui.graphics.painter.Painter
import java.math.BigDecimal
import java.math.RoundingMode

data class TrendingCategory(
    val title: String,
    val icon: Painter,
)

data class Restaurant(
    val name: String = "Restaurant Name",
    val rating: Double = BigDecimal((Math.random() * 5))
        .setScale(1, RoundingMode.HALF_UP)
        .toDouble(),
    val reviews: Int = (Math.random() * 200).toInt(),
    val emptySlots: Int = (Math.random() * 100).toInt(),
    val banner: Painter,
)

