package com.rutubishi.android.ui.presentation.components

import androidx.annotation.DrawableRes
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.animation.slideInVertically
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rutubishi.android.R

@Composable
fun HomeBottomBar(
    modifier: Modifier = Modifier,
) {

    var selectedIndex by remember { mutableStateOf(0) }

    BottomAppBar(
        actions = {
            Row(
                modifier = Modifier
                    .padding(end = 8.dp, start = 8.dp)
                    .weight(7f),
                horizontalArrangement = Arrangement.SpaceBetween) {
                MenuBarItems.forEachIndexed { index, it ->
                    MenuBarItem(
                        onClick = {
                            selectedIndex = index
                            it.third() },
                        isActive = selectedIndex == index,
                        icon = it.first,
                        title = it.second
                    )
                }

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
    var selectedIndex by remember { mutableStateOf(0) }

    NavigationRail(modifier = modifier){
       MenuBarItems.forEachIndexed { index, it ->
           MenuBarItem(
               onClick = {
                   selectedIndex = index
                   it.third() },
               isActive = selectedIndex == index,
               icon = it.first,
               title = it.second
           )
       }
    }
}

@Composable
fun MenuBarItem(
    modifier: Modifier = Modifier,
    onClick: () -> Unit = {},
    isActive: Boolean = false,
    @DrawableRes icon: Int,
    title: String,
) {

    val density = LocalDensity.current

    Column(
        modifier = modifier
            .padding(8.dp)
            .clickable { onClick() },
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        Icon(
            painter = painterResource(id = icon),
            contentDescription = title,
            tint = if(isActive) MaterialTheme.colorScheme.tertiary else MaterialTheme.colorScheme.primary
        )

        AnimatedVisibility(
            visible = isActive,
            enter = slideInVertically {
                with(density){
                    -10.dp.roundToPx()
                }
            }
        ){
            Text(
                text = title,
                style = MaterialTheme.typography.bodySmall,
                color = MaterialTheme.colorScheme.tertiary
            )
        }
    }

}

private val MenuBarItems: List<Triple<Int, String, () -> Unit>> = listOf(
    Triple(R.drawable.ic_home, "Home") {},
    Triple(R.drawable.ic_restaurants, "Restaurants") {},
    Triple(R.drawable.ic_favorites, "Favorites") {},
    Triple(R.drawable.ic_profile, "Profile") {},
)

