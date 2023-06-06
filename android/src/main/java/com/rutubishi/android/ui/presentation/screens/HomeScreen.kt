package com.rutubishi.android.ui.presentation.screens

import androidx.compose.foundation.layout.*
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.verticalScroll
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rutubishi.android.R
import com.rutubishi.common.ui.presentation.components.*
import com.rutubishi.common.ui.util.Restaurant
import com.rutubishi.common.ui.util.TrendingCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    tabletMode: Boolean = true,
    paddingValues: PaddingValues,
) {

    var searchQuery by rememberSaveable {
        mutableStateOf("")
    }

    if(tabletMode){

        Row(modifier = Modifier
            .fillMaxSize()
            .padding(paddingValues)){

            SectionAdBanner(
                modifier = Modifier
                    .weight(1f)
                    .fillMaxHeight()
                    .padding(8.dp),
                searchQuery = searchQuery,
                onSearchQueryChanged = { searchQuery = it }
            )

            Column(
                modifier = Modifier
                    .weight(1f)
                    .padding(end = 8.dp, start = 8.dp, bottom = 8.dp),
            ) {

                ListSectionTitle(
                    modifier = Modifier.fillMaxWidth(),
                    title = "Popular Near You",
                    icon = painterResource(id = R.drawable.ic_arrow_right),
                )

                PopularRestaurantList(
                    tabletMode = tabletMode,
                    restaurants = (1..10).map {
                        Restaurant(
                            banner = painterResource(id = R.drawable.app_banner),
                            name = "Burger King",
                        )
                    }
                )
            }



        }

    }else{
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .padding(paddingValues)
                .verticalScroll(rememberScrollState())) {

            SectionAdBanner(
                searchQuery = searchQuery,
                onSearchQueryChanged = { searchQuery = it }
            )

            ListSectionTitle(
                title = "Popular Near You",
                icon = painterResource(id = R.drawable.ic_arrow_right),
            )

            PopularRestaurantList(
                modifier = Modifier
                    .padding(top = 8.dp),
                restaurants = (1..10).map {
                    Restaurant(
                        banner = painterResource(id = R.drawable.app_banner),
                        name = "Burger King",
                    )
                }
            )
        }
    }

}

@ExperimentalMaterial3Api
@Composable
private fun SectionAdBanner(
    modifier: Modifier = Modifier,
    searchQuery: String,
    onSearchQueryChanged: (String) -> Unit,
) {

    Column(
        modifier = modifier
    ) {

        AdBanner(
            message = "Get 30% off your first order",
            bannerImage = painterResource(id = R.drawable.app_banner),
        )

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(vertical = 4.dp)
                .height(TextFieldDefaults.MinHeight),
            leadingIcon = painterResource(id = R.drawable.ic_search),
            trailingIcon = painterResource(id = R.drawable.ic_filter),
            leadingIconDescription = "Search",
            trailingIconDescription = "Filter",
            hint = "Search for food",
            onValueChange = onSearchQueryChanged,
            text = searchQuery
        )

        SearchOptionsList(
            modifier = Modifier
                .padding(vertical = 8.dp),
            options = listOf("Fast Food", "Burger", "Pizza", "Asian", "Dessert"),
            onOptionSelected = onSearchQueryChanged
        )

        ListSectionTitle(
            title = "Trending",
            icon = painterResource(id = R.drawable.ic_arrow_right),
        )

        TrendingFoodList(
            modifier = Modifier
                .padding(top = 8.dp),
            trendingCategories = listOf(
                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)
                ),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)
                ),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)
                ),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)
                ),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)
                ),


                )
        )
    }
}