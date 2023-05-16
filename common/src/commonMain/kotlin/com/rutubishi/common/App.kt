package com.rutubishi.common

import androidx.compose.material3.Button
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import com.rutubishi.common.ui.color.TableTopTheme

@Composable
fun App() {
    var text by remember { mutableStateOf("Hello, World!") }
    val platformName = getPlatformName()

    TableTopTheme {
        Button(onClick = {
            text = "Hello, $platformName"
        }) {
            Text(text)
        }
    }

}
