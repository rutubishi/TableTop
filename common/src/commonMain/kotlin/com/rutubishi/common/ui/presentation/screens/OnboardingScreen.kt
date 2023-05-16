package com.rutubishi.common.ui.presentation.screens

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Shadow
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.rutubishi.common.ui.wrappers.getOnBoardingButtonIcon
import com.rutubishi.common.ui.wrappers.getOnboardingImage

@Composable
fun OnboardingScreen(
    modifier: Modifier = Modifier,
    screenPadding: PaddingValues = PaddingValues(0.dp),

    ) {

    Image(
        modifier = Modifier
            .fillMaxWidth()
            .height(350.dp),
        painter = getOnboardingImage(),
        contentScale = ContentScale.Crop,
        alignment = Alignment.Center,
        contentDescription = "App Banner"
    )

    Column(
        modifier = modifier.padding(screenPadding),
        horizontalAlignment = Alignment.CenterHorizontally,
        verticalArrangement = Arrangement.Bottom) {

        Text(
            modifier = Modifier
                .padding(vertical = 48.dp, horizontal = 16.dp),
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize),
                ) {
                    append("Needless to worry, ")
                }
                append("Catch that dinner exactly how you want it with ")
                withStyle(
                    style = SpanStyle(
                        fontStyle = FontStyle.Normal,
                        fontWeight = FontWeight.SemiBold,
                        fontSize = MaterialTheme.typography.headlineLarge.fontSize,
                        shadow = Shadow(
                            color = MaterialTheme.colorScheme.tertiaryContainer,
                            blurRadius = 1f,
                            offset = androidx.compose.ui.geometry.Offset(1f, 1f))
                    ),

                ) {
                    append("TableTop")
                }
            },
            style = MaterialTheme.typography.headlineSmall.copy(fontWeight = FontWeight.Light),
            textAlign = TextAlign.Center
        )

        Text(
            text = "Explore your favorite restaurants and reserve a table for your next meal.",
            modifier = Modifier
                .padding(bottom = 64.dp, end = 16.dp, start = 16.dp),
            fontWeight = FontWeight.Light,
            style = MaterialTheme.typography.bodySmall,
            textAlign = TextAlign.Center
        )

        Button(onClick = { /*TODO*/ }) {
            Row(
                modifier = Modifier
                    .padding(10.dp),
                horizontalArrangement = Arrangement.SpaceEvenly,
                verticalAlignment = Alignment.CenterVertically
            ){

                Text(
                    text = "GET STARTED",
                    style = MaterialTheme.typography.labelLarge)

                Spacer(modifier = Modifier.width(8.dp))

                Icon(
                    painter = getOnBoardingButtonIcon(),
                    contentDescription = "Get Started",
                )


            }
        }

    }

}