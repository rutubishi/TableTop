package com.rutubishi.android.ui.presentation.components

import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import com.rutubishi.android.R

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
) {

    BottomAppBar(
        actions = {
            IconButton(onClick = { /*TODO*/ }){
                Icon(
                    painter = painterResource(id = R.drawable.ic_home),
                    contentDescription = "home"
                )
            }

            IconButton(onClick = { /*TODO*/ }){
                Icon(
                    painter = painterResource(id = R.drawable.ic_restaurants),
                    contentDescription = "restaurants"
                )
            }

            IconButton(onClick = { /*TODO*/ }){
                Icon(
                    painter = painterResource(id = R.drawable.ic_favorites),
                    contentDescription = "favorites"
                )
            }

            IconButton(onClick = { /*TODO*/ }){
                Icon(
                    painter = painterResource(id = R.drawable.ic_profile),
                    contentDescription = "profile",
                )
            }

        },
        modifier = modifier,
        floatingActionButton = {
            FloatingActionButton(
                onClick = { /*TODO*/ },
                containerColor = MaterialTheme.colorScheme.tertiaryContainer,
                contentColor = MaterialTheme.colorScheme.onTertiaryContainer,
                shape = CircleShape,
                content = {
                    Icon(
                        painter = painterResource(id = R.drawable.ic_hotel_star),
                        contentDescription = "Cart",
                        tint = MaterialTheme.colorScheme.onTertiaryContainer
                    )
                })
        }
    )

}

@Composable
fun HomeNavigationRail(
    modifier: Modifier = Modifier,
){
    NavigationRail(modifier = modifier){
        IconButton(onClick = { /*TODO*/ }){
            Icon(
                painter = painterResource(id = R.drawable.ic_home),
                contentDescription = "home"
            )
        }

        IconButton(onClick = { /*TODO*/ }){
            Icon(
                painter = painterResource(id = R.drawable.ic_restaurants),
                contentDescription = "restaurants"
            )
        }

        IconButton(onClick = { /*TODO*/ }){
            Icon(
                painter = painterResource(id = R.drawable.ic_favorites),
                contentDescription = "favorites"
            )
        }

        IconButton(onClick = { /*TODO*/ }){
            Icon(
                painter = painterResource(id = R.drawable.ic_profile),
                contentDescription = "profile",
            )
        }
    }
}

