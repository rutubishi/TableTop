package com.rutubishi.common.ui.theme

import androidx.compose.ui.text.font.Font
import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import com.rutubishi.common.R

internal actual val appFontFamily: FontFamily = FontFamily(
    Font(resId = R.font.signika_bold, weight = FontWeight.Bold),
    Font(resId = R.font.signika_light, weight = FontWeight.Light),
    Font(resId = R.font.signika_regular, weight = FontWeight.Normal),
    Font(resId = R.font.signika_medium, weight = FontWeight.Medium),
    Font(resId = R.font.signika_semibold, weight = FontWeight.SemiBold),
)
