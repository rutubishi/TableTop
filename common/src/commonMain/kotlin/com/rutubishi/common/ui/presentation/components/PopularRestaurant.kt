package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontStyle
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp
import com.rutubishi.common.ui.util.Restaurant

@ExperimentalMaterial3Api
@Composable
fun PopularRestaurant(
    modifier: Modifier = Modifier,
    rating: Double = 4.2,
    reviews: Int = 10,
    emptySlots: Int = 20,
    onClick: () -> Unit = {},
    banner: Painter,
    name: String,
) {

    Card(
        modifier = modifier,
        onClick = onClick,
    ) {

        Column(modifier = Modifier) {

            Image(
                modifier = Modifier
                    .height(125.dp)
                    .padding(bottom = 8.dp),
                painter = banner,
                contentDescription = name,
                contentScale = ContentScale.Crop,
                alignment = Alignment.Center
            )

            Column(
                modifier = Modifier
                    .padding(horizontal = 8.dp)
                    .padding(bottom = 2.dp),
            ) {

                    // reviews and rating
                    Row(
                        modifier = Modifier
                            .padding(bottom = 4.dp),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceEvenly
                    ) {

                        StarRating(rating = rating)

                        Text(
                            modifier =Modifier
                                .padding(start = 2.dp),
                            text = parseReviews(reviews),
                        )

                    }

                    // restaurant name
                    Text(
                        text = name,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        style = MaterialTheme.typography.bodyLarge,
                    )

                    // empty slots
                    RestaurantSlots(
                        modifier = Modifier
                            .padding(bottom = 8.dp),
                        emptySlots = emptySlots
                    )

            }

        }

    }

}


@Composable
fun StarRating(
    rating: Double = 0.0,
) {

    Row(
        verticalAlignment = Alignment.CenterVertically,
    ) {

        Icon(
            imageVector = Icons.Default.Star,
            contentDescription = "Rating",
            modifier = Modifier
                .size(24.dp),
            tint = MaterialTheme.colorScheme.tertiary
        )

        Spacer(modifier = Modifier.padding(2.dp))

        Text(
            text = rating.toString(),
            fontWeight = FontWeight.Bold,
        )

    }

}


@Composable
fun RestaurantSlots(
    modifier: Modifier = Modifier,
    emptySlots: Int = 0,
){
    if (emptySlots < 1)
        Text(
            modifier = modifier,
            text = "NO EMPTY SLOTS",
            fontWeight = FontWeight.Bold,
            style = MaterialTheme.typography.bodyMedium,
        )
    else
        Text(
            modifier = modifier,
            text = buildAnnotatedString {
                withStyle(
                    style = SpanStyle(
                        fontWeight = FontWeight.Normal,
                        color = MaterialTheme.colorScheme.tertiary
                    )
                ) {
                    append("$emptySlots")
                }
                append(" EMPTY SLOTS")
            },
            style = MaterialTheme.typography.bodyMedium,
        )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun PopularRestaurantList(
    modifier: Modifier = Modifier,
    restaurants: List<Restaurant>,
) {

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(8.dp),
        verticalAlignment = Alignment.CenterVertically
    ) {

        items(restaurants) { restaurant ->
            PopularRestaurant(
                modifier = Modifier
                    .width(250.dp),
                rating = restaurant.rating,
                reviews = restaurant.reviews,
                emptySlots = restaurant.emptySlots,
                banner = restaurant.banner,
                name = restaurant.name,
            )
        }

    }

}


fun parseReviews(reviews: Int): String {
    val reviewData = if(reviews < 100) "$reviews" else "100+"
    return "($reviewData reviews)"
}