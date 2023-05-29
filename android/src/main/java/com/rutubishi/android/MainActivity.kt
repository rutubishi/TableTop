package com.rutubishi.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.windowsizeclass.ExperimentalMaterial3WindowSizeClassApi
import androidx.compose.material3.windowsizeclass.WindowWidthSizeClass
import androidx.compose.material3.windowsizeclass.calculateWindowSizeClass
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rutubishi.android.ui.navigation.AuthNavHost
import com.rutubishi.common.App
import com.rutubishi.common.ui.theme.TableTopTheme

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class, ExperimentalMaterial3WindowSizeClassApi::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableTopTheme {

                val windowSize = calculateWindowSizeClass(this)
                val tabletMode = windowSize.widthSizeClass > WindowWidthSizeClass.Compact

                AuthNavHost(
                    tabletMode = tabletMode,
                    modifier = Modifier
                        .padding(
                            start = 16.dp,
                            end = 16.dp,
                        )
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
