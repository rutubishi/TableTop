package com.rutubishi.android

import android.os.Bundle
import androidx.activity.compose.setContent
import androidx.appcompat.app.AppCompatActivity
import androidx.compose.runtime.Composable
import androidx.compose.ui.tooling.preview.Preview
import com.rutubishi.android.ui.presentation.components.HomeAppBar
import com.rutubishi.common.App
import com.rutubishi.common.ui.theme.TableTopTheme

class MainActivity : AppCompatActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            TableTopTheme {
                HomeAppBar()
            }
        }
    }

}

@Composable
@Preview
fun DefaultAppPreview() {
    App()
}
