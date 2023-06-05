package com.rutubishi.android.ui.navigation

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.rutubishi.android.R
import com.rutubishi.android.ui.presentation.viewmodels.AuthVM
import com.rutubishi.common.ui.presentation.screens.auth.LoginScreen
import com.rutubishi.common.ui.presentation.screens.auth.RegisterScreen

@Composable
@ExperimentalMaterial3Api
fun AuthNavHost(
    modifier: Modifier = Modifier,
    tabletMode: Boolean,
    authVM: AuthVM,
    loader: @Composable () -> Unit = {},
    navController: NavHostController = rememberNavController(),
    startDestination: String = "login"
) {

    NavHost(
        modifier = Modifier,
        startDestination = startDestination,
        navController = navController,
    ){
        fun navigateToHome() {
            navController.popBackStack()
            navController.navigate("main")
        }

        mainGraph(navController = navController)

        composable("login"){
           LoginScreen(
               tabletMode = tabletMode,
               modifier = modifier,
               bannerImg = painterResource(id = R.drawable.login),
               onNavigateToRegister = { navController.navigate("register") },
               onLoginSuccess = ::navigateToHome,
               loader = loader,
               onLogin = authVM::login,
               screenState = authVM.authState.value)
        }

        composable("register"){
            RegisterScreen(
                tabletMode = tabletMode,
                modifier = modifier,
                bannerImg = painterResource(id = R.drawable.register),
                onNavigateToLogin = { navController.navigate("login") },
                onRegisterSuccess = ::navigateToHome,
                loader = loader,
                onRegister = authVM::register,
                screenState = authVM.authState.value)
        }

    }

}

