package com.rutubishi.android.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rutubishi.android.R
import com.rutubishi.common.ui.presentation.screens.auth.LoginScreen
import com.rutubishi.common.ui.presentation.screens.auth.RegisterScreen

@Composable
@ExperimentalMaterial3Api
@ExperimentalMaterial3WindowSizeClassApi
fun AuthNavHost(
    modifier: Modifier = Modifier,
    tabletMode: Boolean,
    navController: NavHostController = rememberNavController(),
    startDestination: String = "login"
) {


    NavHost(
        modifier = Modifier,
        startDestination = startDestination,
        navController = navController,
    ){

       composable("login"){
            LoginScreen(
                tabletMode = tabletMode,
                modifier = modifier,
                bannerImg = painterResource(id = R.drawable.login),
                onNavigateToRegister = { navController.navigate("register") },
            )
        }

        composable("register"){
            RegisterScreen(
                tabletMode = tabletMode,
                modifier = modifier,
                bannerImg = painterResource(id = R.drawable.register),
                onNavigateToLogin = { navController.navigate("login") },
            )
        }
    }

}