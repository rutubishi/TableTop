package com.rutubishi.android.ui.presentation.screens

import android.util.Log
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import com.rutubishi.android.R
import com.rutubishi.common.ui.presentation.components.ListSectionTitle
import com.rutubishi.common.ui.presentation.components.PopularRestaurant
import com.rutubishi.common.ui.presentation.components.PopularRestaurantList
import com.rutubishi.common.ui.presentation.components.SearchBar
import com.rutubishi.common.ui.presentation.components.TrendingFood
import com.rutubishi.common.ui.presentation.components.TrendingFoodList
import com.rutubishi.common.ui.util.Restaurant
import com.rutubishi.common.ui.util.TrendingCategory

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    paddingValues: PaddingValues,
) {

    var searchQuery by rememberSaveable{
        mutableStateOf("")
    }

    Column(
        modifier = Modifier
            .padding(paddingValues)) {

        SearchBar(
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp)
                .height(TextFieldDefaults.MinHeight),
            leadingIcon = painterResource(id = R.drawable.ic_search),
            trailingIcon = painterResource(id = R.drawable.ic_filter),
            leadingIconDescription = "Search",
            trailingIconDescription = "Filter",
            hint = "Search for food",
            onValueChange = { searchQuery = it },
            text = searchQuery
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
                    icon = painterResource(id = R.drawable.ic_burger)),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)),

                TrendingCategory(
                    title = "Burger",
                    icon = painterResource(id = R.drawable.ic_burger)),


                )
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