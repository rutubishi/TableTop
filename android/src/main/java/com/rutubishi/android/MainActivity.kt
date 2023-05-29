package com.rutubishi.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FabPosition
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rutubishi.android.ui.presentation.components.HomeAppBar
import com.rutubishi.android.ui.presentation.components.HomeBottomBar
import com.rutubishi.android.ui.presentation.screens.HomeScreen
import com.rutubishi.common.App
import com.rutubishi.common.ui.presentation.components.AuthScreen
import com.rutubishi.common.ui.presentation.screens.auth.LoginScreen
import com.rutubishi.common.ui.presentation.screens.auth.RegisterScreen
import com.rutubishi.common.ui.theme.TableTopTheme

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableTopTheme {
/*                Scaffold(
                    modifier = Modifier,
                    topBar = {
                        HomeAppBar()
                    },
                    bottomBar = {
                        HomeBottomBar()
                    },
                    floatingActionButtonPosition = FabPosition.Center,
                ) { padding ->

                    HomeScreen(paddingValues = PaddingValues(
                        top = padding.calculateTopPadding(),
                        bottom = padding.calculateBottomPadding(),
                        start = 16.dp,
                        end = 16.dp,
                    ))

                }*/
                RegisterScreen(
                    bannerImg = painterResource(id = R.drawable.register),
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp),
                )

            }
        }
    }

}

@Composable
@Preview
fun DefaultAppPreview() {
    App()
}
