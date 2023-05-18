package com.rutubishi.common.ui.theme

import androidx.compose.ui.text.font.FontFamily
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.platform.Font
import java.io.File

internal actual val appFontFamily: FontFamily = FontFamily(
    Font(resource = File("font/signika_bold.ttf").path, weight = FontWeight.Bold),
    Font(resource = File("font/signika_light.ttf").path, weight = FontWeight.Light),
    Font(resource = File("font/signika_regular.ttf").path, weight = FontWeight.Normal),
    Font(resource = File("font/signika_medium.ttf").path, weight = FontWeight.Medium),
    Font(resource = File("font/signika_semibold.ttf").path, weight = FontWeight.SemiBold),
)