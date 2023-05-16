package com.rutubishi.common

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.rutubishi.common.ui.presentation.screens.OnboardingScreen
import com.rutubishi.common.ui.theme.TableTopTheme

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun App() {

    TableTopTheme {

        Scaffold(
            modifier = Modifier
                .fillMaxSize()
        ){
            OnboardingScreen(
                modifier = Modifier
                    .fillMaxSize(),
                screenPadding = PaddingValues(top = 16.dp, start = 8.dp, end = 8.dp, bottom = 32.dp)
            )
        }


    }

}
