package com.rutubishi.android

import android.os.Bundle
import android.util.Log
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.rutubishi.android.ui.presentation.components.HomeAppBar
import com.rutubishi.android.ui.presentation.screens.HomeScreen
import com.rutubishi.common.App
import com.rutubishi.common.ui.presentation.components.SearchBar
import com.rutubishi.common.ui.presentation.components.TrendingFood
import com.rutubishi.common.ui.theme.TableTopTheme

class MainActivity : AppCompatActivity() {
    @OptIn(ExperimentalMaterial3Api::class)
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableTopTheme {
                Scaffold(
                    modifier = Modifier.padding(16.dp),
                    topBar = {
                        HomeAppBar()
                    }
                ) { padding ->

                    HomeScreen(paddingValues = padding)

                }

            }
        }
    }

}

@Composable
@Preview
fun DefaultAppPreview() {
    App()
}
