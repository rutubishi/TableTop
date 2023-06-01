package com.rutubishi.common.ui.theme

import androidx.compose.foundation.isSystemInDarkTheme
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.TextField
import androidx.compose.material3.Typography
import androidx.compose.material3.lightColorScheme
import androidx.compose.material3.darkColorScheme
import androidx.compose.runtime.Composable
import androidx.compose.ui.text.TextStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.sp
import com.rutubishi.common.ui.color.md_theme_dark_background
import com.rutubishi.common.ui.color.md_theme_dark_error
import com.rutubishi.common.ui.color.md_theme_dark_errorContainer
import com.rutubishi.common.ui.color.md_theme_dark_inverseOnSurface
import com.rutubishi.common.ui.color.md_theme_dark_inversePrimary
import com.rutubishi.common.ui.color.md_theme_dark_inverseSurface
import com.rutubishi.common.ui.color.md_theme_dark_onBackground
import com.rutubishi.common.ui.color.md_theme_dark_onError
import com.rutubishi.common.ui.color.md_theme_dark_onErrorContainer
import com.rutubishi.common.ui.color.md_theme_dark_onPrimary
import com.rutubishi.common.ui.color.md_theme_dark_onPrimaryContainer
import com.rutubishi.common.ui.color.md_theme_dark_onSecondary
import com.rutubishi.common.ui.color.md_theme_dark_onSecondaryContainer
import com.rutubishi.common.ui.color.md_theme_dark_onSurface
import com.rutubishi.common.ui.color.md_theme_dark_onSurfaceVariant
import com.rutubishi.common.ui.color.md_theme_dark_onTertiary
import com.rutubishi.common.ui.color.md_theme_dark_onTertiaryContainer
import com.rutubishi.common.ui.color.md_theme_dark_outline
import com.rutubishi.common.ui.color.md_theme_dark_outlineVariant
import com.rutubishi.common.ui.color.md_theme_dark_primary
import com.rutubishi.common.ui.color.md_theme_dark_primaryContainer
import com.rutubishi.common.ui.color.md_theme_dark_scrim
import com.rutubishi.common.ui.color.md_theme_dark_secondary
import com.rutubishi.common.ui.color.md_theme_dark_secondaryContainer
import com.rutubishi.common.ui.color.md_theme_dark_surface
import com.rutubishi.common.ui.color.md_theme_dark_surfaceTint
import com.rutubishi.common.ui.color.md_theme_dark_surfaceVariant
import com.rutubishi.common.ui.color.md_theme_dark_tertiary
import com.rutubishi.common.ui.color.md_theme_dark_tertiaryContainer
import com.rutubishi.common.ui.color.md_theme_light_background
import com.rutubishi.common.ui.color.md_theme_light_error
import com.rutubishi.common.ui.color.md_theme_light_errorContainer
import com.rutubishi.common.ui.color.md_theme_light_inverseOnSurface
import com.rutubishi.common.ui.color.md_theme_light_inversePrimary
import com.rutubishi.common.ui.color.md_theme_light_inverseSurface
import com.rutubishi.common.ui.color.md_theme_light_onBackground
import com.rutubishi.common.ui.color.md_theme_light_onError
import com.rutubishi.common.ui.color.md_theme_light_onErrorContainer
import com.rutubishi.common.ui.color.md_theme_light_onPrimary
import com.rutubishi.common.ui.color.md_theme_light_onPrimaryContainer
import com.rutubishi.common.ui.color.md_theme_light_onSecondary
import com.rutubishi.common.ui.color.md_theme_light_onSecondaryContainer
import com.rutubishi.common.ui.color.md_theme_light_onSurface
import com.rutubishi.common.ui.color.md_theme_light_onSurfaceVariant
import com.rutubishi.common.ui.color.md_theme_light_onTertiary
import com.rutubishi.common.ui.color.md_theme_light_onTertiaryContainer
import com.rutubishi.common.ui.color.md_theme_light_outline
import com.rutubishi.common.ui.color.md_theme_light_outlineVariant
import com.rutubishi.common.ui.color.md_theme_light_primary
import com.rutubishi.common.ui.color.md_theme_light_primaryContainer
import com.rutubishi.common.ui.color.md_theme_light_scrim
import com.rutubishi.common.ui.color.md_theme_light_secondary
import com.rutubishi.common.ui.color.md_theme_light_secondaryContainer
import com.rutubishi.common.ui.color.md_theme_light_surface
import com.rutubishi.common.ui.color.md_theme_light_surfaceTint
import com.rutubishi.common.ui.color.md_theme_light_surfaceVariant
import com.rutubishi.common.ui.color.md_theme_light_tertiary
import com.rutubishi.common.ui.color.md_theme_light_tertiaryContainer


private val LightColors = lightColorScheme(
    primary = md_theme_light_primary,
    onPrimary = md_theme_light_onPrimary,
    primaryContainer = md_theme_light_primaryContainer,
    onPrimaryContainer = md_theme_light_onPrimaryContainer,
    secondary = md_theme_light_secondary,
    onSecondary = md_theme_light_onSecondary,
    secondaryContainer = md_theme_light_secondaryContainer,
    onSecondaryContainer = md_theme_light_onSecondaryContainer,
    tertiary = md_theme_light_tertiary,
    onTertiary = md_theme_light_onTertiary,
    tertiaryContainer = md_theme_light_tertiaryContainer,
    onTertiaryContainer = md_theme_light_onTertiaryContainer,
    error = md_theme_light_error,
    errorContainer = md_theme_light_errorContainer,
    onError = md_theme_light_onError,
    onErrorContainer = md_theme_light_onErrorContainer,
    background = md_theme_light_background,
    onBackground = md_theme_light_onBackground,
    surface = md_theme_light_surface,
    onSurface = md_theme_light_onSurface,
    surfaceVariant = md_theme_light_surfaceVariant,
    onSurfaceVariant = md_theme_light_onSurfaceVariant,
    outline = md_theme_light_outline,
    inverseOnSurface = md_theme_light_inverseOnSurface,
    inverseSurface = md_theme_light_inverseSurface,
    inversePrimary = md_theme_light_inversePrimary,
    surfaceTint = md_theme_light_surfaceTint,
    outlineVariant = md_theme_light_outlineVariant,
    scrim = md_theme_light_scrim,
)


private val DarkColors = darkColorScheme(
    primary = md_theme_dark_primary,
    onPrimary = md_theme_dark_onPrimary,
    primaryContainer = md_theme_dark_primaryContainer,
    onPrimaryContainer = md_theme_dark_onPrimaryContainer,
    secondary = md_theme_dark_secondary,
    onSecondary = md_theme_dark_onSecondary,
    secondaryContainer = md_theme_dark_secondaryContainer,
    onSecondaryContainer = md_theme_dark_onSecondaryContainer,
    tertiary = md_theme_dark_tertiary,
    onTertiary = md_theme_dark_onTertiary,
    tertiaryContainer = md_theme_dark_tertiaryContainer,
    onTertiaryContainer = md_theme_dark_onTertiaryContainer,
    error = md_theme_dark_error,
    errorContainer = md_theme_dark_errorContainer,
    onError = md_theme_dark_onError,
    onErrorContainer = md_theme_dark_onErrorContainer,
    background = md_theme_dark_background,
    onBackground = md_theme_dark_onBackground,
    surface = md_theme_dark_surface,
    onSurface = md_theme_dark_onSurface,
    surfaceVariant = md_theme_dark_surfaceVariant,
    onSurfaceVariant = md_theme_dark_onSurfaceVariant,
    outline = md_theme_dark_outline,
    inverseOnSurface = md_theme_dark_inverseOnSurface,
    inverseSurface = md_theme_dark_inverseSurface,
    inversePrimary = md_theme_dark_inversePrimary,
    surfaceTint = md_theme_dark_surfaceTint,
    outlineVariant = md_theme_dark_outlineVariant,
    scrim = md_theme_dark_scrim,
)

internal val typography: Typography = Typography(
    displayLarge = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 96.sp
    ),
    displayMedium = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 60.sp
    ),
    displaySmall = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 48.sp
    ),
    headlineLarge = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 34.sp
    ),
    headlineMedium = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 24.sp
    ),
    headlineSmall = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Bold,
        fontSize = 20.sp
    ),
    titleMedium = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    titleSmall = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    bodyLarge = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 16.sp
    ),
    bodySmall = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 14.sp
    ),
    labelLarge = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Medium,
        fontSize = 14.sp
    ),
    labelSmall = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    ),
    labelMedium = TextStyle(
        fontFamily = appFontFamily,
        fontWeight = FontWeight.Normal,
        fontSize = 12.sp
    )
)

@Composable
fun TableTopTheme(
    useDarkTheme: Boolean = isSystemInDarkTheme(),
    content: @Composable() () -> Unit
) {
    val colors = if (!useDarkTheme) {
        LightColors
    } else {
        DarkColors
    }

    MaterialTheme(
        colorScheme = colors,
        content = content,
        typography = typography
    )
}