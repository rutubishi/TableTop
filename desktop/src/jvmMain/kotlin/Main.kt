import androidx.compose.desktop.ui.tooling.preview.Preview
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Window
import androidx.compose.ui.window.application
import com.rutubishi.common.App
import com.rutubishi.common.ui.presentation.screens.auth.LoginScreen
import com.rutubishi.common.ui.util.loadPainter


@OptIn(ExperimentalMaterial3Api::class)
fun main() = application {
    Window(onCloseRequest = ::exitApplication) {
        LoginScreen(
            bannerImg = painterResource(loadPainter("register.png")),
            modifier = Modifier
                .padding(
                    start = 16.dp,
                    end = 16.dp
                )
        )
    }
}


@OptIn(ExperimentalMaterial3Api::class)
@Composable
@Preview
fun AppPreview() {
    LoginScreen(
        bannerImg = painterResource(loadPainter("register.png")),
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp
            )
    )
}