import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.runtime.Composable
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rutubishi.common.App



fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}


@Composable
@Preview
fun AppPreview() {
    App()
}