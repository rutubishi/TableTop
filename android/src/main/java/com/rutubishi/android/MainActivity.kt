package com.rutubishi.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import androidx.navigation.compose.rememberNavController
import com.rutubishi.android.ui.navigation.AuthNavHost
import com.rutubishi.android.ui.presentation.components.AppLoader
import com.rutubishi.android.ui.presentation.screens.HomeScreen
import com.rutubishi.android.ui.presentation.viewmodels.AuthVM
import com.rutubishi.common.App
import com.rutubishi.common.data.repository.AuthRepository
import com.rutubishi.common.ui.theme.TableTopTheme
import org.koin.androidx.compose.get

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableTopTheme {
                val windowSize = calculateWindowSizeClass(this)
                val tabletMode = windowSize.widthSizeClass > WindowWidthSizeClass.Compact

                // inject view-models
                val authVM = AuthVM(AuthRepository(get()))

                AuthNavHost(
                    navController = rememberNavController(),
                    tabletMode = tabletMode,
                    authVM = authVM,
                    loader = { AppLoader() },
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                        )
                )
//                HomeScreen(
//                    paddingValues = PaddingValues(16.dp)
//                )
            }
        }
    }

}

@Composable
@Preview
fun DefaultAppPreview() {
    App()
}
