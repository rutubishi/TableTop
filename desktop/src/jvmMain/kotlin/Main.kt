import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rutubishi.common.App



fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        App()
    }
}
