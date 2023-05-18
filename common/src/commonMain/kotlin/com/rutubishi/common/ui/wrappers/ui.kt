package com.rutubishi.common.ui.wrappers

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter

/**
 * All shared UI code with platform specific implementation should be placed here.
 */
@Composable
internal expect fun getOnboardingImage(): Painter
@Composable
internal expect fun getOnBoardingButtonIcon(): Painter
