package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
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

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TrendingFoodList(
    trendingCategories: List<TrendingCategory>,
    modifier: Modifier = Modifier,
) {

    LazyRow(
        modifier = modifier,
        verticalAlignment = Alignment.CenterVertically,
        contentPadding = PaddingValues(4.dp)
    ) {

        items (trendingCategories) { category ->
            TrendingFood(
                painter = category.icon,
                contentDescription = category.title,
                title = category.title,
                onClick = { /*TODO*/ }
            )

        }

    }

}