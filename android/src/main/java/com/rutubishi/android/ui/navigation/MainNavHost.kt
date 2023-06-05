package com.rutubishi.android.ui.navigation

import androidx.compose.foundation.layout.WindowInsets
import androidx.compose.material3.Scaffold
import androidx.compose.ui.unit.dp
import androidx.navigation.NavController
import androidx.navigation.NavGraphBuilder
import androidx.navigation.compose.composable
import androidx.navigation.navigation
import com.rutubishi.android.ui.presentation.components.HomeAppBar
import com.rutubishi.android.ui.presentation.components.HomeBottomBar
import com.rutubishi.android.ui.presentation.screens.HomeScreen


fun NavGraphBuilder.mainGraph(
    navController: NavController
){
    navigation(startDestination = "home", route = "main"){
        composable("home"){
            Scaffold(
                contentWindowInsets = WindowInsets(left = 16.dp, right = 16.dp, bottom = 8.dp),
                bottomBar = { HomeBottomBar() },
                topBar = { HomeAppBar() },
            ) { paddingValues ->
                HomeScreen(paddingValues = paddingValues)
            }
        }
    }

}