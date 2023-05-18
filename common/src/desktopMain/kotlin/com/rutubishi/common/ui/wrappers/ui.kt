package com.rutubishi.common.ui.wrappers

import androidx.compose.runtime.Composable
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import com.rutubishi.common.ui.util.loadPainter
import java.io.File
import java.io.IOException
import kotlin.jvm.Throws

@Composable
@Throws(IOException::class)
internal actual fun getOnboardingImage(): Painter =
    painterResource(loadPainter("app_banner.png"))

@Composable
internal actual fun getOnBoardingButtonIcon(): Painter =
    painterResource(loadPainter("ic_right.png"))