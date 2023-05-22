package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Card
import androidx.compose.material3.CardColors
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.CircularProgressIndicator
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.CompositionLocalProvider
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.ColorFilter
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import io.kamel.core.config.KamelConfig
import io.kamel.core.config.httpFetcher
import io.kamel.image.KamelImage
import io.kamel.image.config.LocalKamelConfig
import io.kamel.image.lazyPainterResource
import io.ktor.client.HttpClient
import io.ktor.client.engine.okhttp.OkHttp
import io.ktor.client.plugins.defaultRequest

@Composable
@ExperimentalMaterial3Api
fun TrendingFood(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    painter: Painter,
    contentDescription: String,
    title: String,
) {


    Card(
        modifier = modifier,
        onClick = onClick,
    ) {

        Column(
            modifier = modifier,
            horizontalAlignment = Alignment.CenterHorizontally,
        ) {

            Image(
                painter = painter,
                modifier = Modifier
                    .size(75.dp)
                    .padding(top = 8.dp),
                contentDescription = contentDescription,
                contentScale = ContentScale.Inside,
            )

            Spacer(modifier = Modifier
                .padding(8.dp))

            Text(
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center
            )

        }

    }

}