package com.rutubishi.android.ui.navigation

import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rutubishi.android.ui.presentation.components.HomeAppBar
import com.rutubishi.android.ui.presentation.components.HomeBottomBar
import com.rutubishi.android.ui.presentation.components.HomeNavigationRail
import com.rutubishi.android.ui.presentation.screens.HomeScreen


fun NavGraphBuilder.mainGraph(
    navController: NavController,
    tabletMode: Boolean = false,
){
    navigation(startDestination = "home", route = "main"){
        composable("home"){

            if(tabletMode){
                Scaffold(
                    contentWindowInsets = WindowInsets(left = 16.dp, right = 16.dp, bottom = 8.dp),
                    topBar = { HomeAppBar() },
                ) { paddingValues ->
                    Row {
                        HomeNavigationRail(
                            modifier = Modifier
                                .padding(top = paddingValues.calculateTopPadding()))
                        HomeScreen(
                            tabletMode = true,
                            paddingValues = paddingValues)
                    }
                }

            }else {

                Scaffold(
                    contentWindowInsets = WindowInsets(left = 16.dp, right = 16.dp, bottom = 8.dp),
                    bottomBar = { HomeBottomBar() },
                    topBar = { HomeAppBar() },
                ) { paddingValues ->
                    HomeScreen(
                        tabletMode = false,
                        paddingValues = paddingValues
                    )
                }
            }
        }
    }

}