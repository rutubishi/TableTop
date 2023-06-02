package com.rutubishi.android.ui.presentation.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.size
import androidx.compose.material3.AlertDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.airbnb.lottie.compose.LottieAnimation
import com.airbnb.lottie.compose.LottieCompositionSpec
import com.airbnb.lottie.compose.LottieConstants
import com.airbnb.lottie.compose.rememberLottieComposition
import com.rutubishi.android.R

@Composable
@ExperimentalMaterial3Api
fun AppLoader(
    modifier: Modifier = Modifier,
) {
    val composition by rememberLottieComposition(spec = LottieCompositionSpec.RawRes(R.raw.app_loader))
    AlertDialog(onDismissRequest = { }){
        Box(modifier = modifier
            .size(200.dp),
            contentAlignment = Alignment.Center) {
            LottieAnimation(
                composition = composition,
                iterations = LottieConstants.IterateForever)

        }
    }
}