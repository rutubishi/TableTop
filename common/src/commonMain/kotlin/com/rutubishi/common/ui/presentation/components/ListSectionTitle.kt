package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
fun ListSectionTitle(
    title: String,
    icon: Painter,
    modifier: Modifier = Modifier
        .padding(top = 16.dp)
        .fillMaxWidth()
) {

    Row(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.SpaceBetween
    ) {

        Text(
            text = title,
            style = MaterialTheme.typography.headlineMedium
        )

        Row(
            verticalAlignment = Alignment.CenterVertically,
        ) {
            Text(
                text = "See all",
                style = MaterialTheme.typography.bodyMedium,
                color = MaterialTheme.colorScheme.tertiary
            )
            Spacer(
                modifier = Modifier
                    .width(8.dp)
            )
            Icon(
                painter = icon,
                contentDescription = "See all",
                modifier = Modifier
                    .padding(start = 4.dp)
                    .size(16.dp),
                tint = MaterialTheme.colorScheme.tertiary
            )
        }

    }

}