package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rutubishi.common.ui.util.TrendingCategory

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
        colors = CardDefaults.cardColors(
            containerColor = MaterialTheme.colorScheme.background,
            contentColor = MaterialTheme.colorScheme.onBackground),
        shape = CircleShape
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
                contentScale = ContentScale.Crop,
            )

            Spacer(modifier = Modifier
                .padding(2.dp))

            Text(
                modifier = Modifier
                    .padding(bottom = 4.dp),
                text = title,
                style = MaterialTheme.typography.bodyMedium,
                fontStyle = FontStyle.Normal,
                textAlign = TextAlign.Center,
                )

        }

    }

}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendingFoodList(
    trendingCategories: List<TrendingCategory>,
    modifier: Modifier = Modifier,
) {

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        horizontalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items (trendingCategories) { category ->
            TrendingFood(
                modifier = Modifier,
                painter = category.icon,
                contentDescription = category.title,
                title = category.title,
                onClick = { /*TODO*/ }
            )

        }

    }

}