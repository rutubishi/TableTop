package com.rutubishi.common.ui.wrappers

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.rutubishi.common.R

@Composable
internal actual fun getOnboardingImage(): Painter = painterResource(R.drawable.app_banner)
@Composable
internal actual fun getOnBoardingButtonIcon(): Painter = painterResource(R.drawable.ic_right)