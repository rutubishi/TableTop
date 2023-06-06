package android.screens

import android.fixtures.AppComposeTest
import androidx.activity.ComponentActivity
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.*
import androidx.compose.ui.test.junit4.createAndroidComposeRule
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rutubishi.android.R
import com.rutubishi.common.ui.presentation.screens.auth.LoginScreen
import com.rutubishi.common.ui.theme.TableTopTheme
import org.junit.Before
import org.junit.Rule
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalMaterial3Api
class LoginScreenTest : AppComposeTest(
    content = {
        LoginScreen(
            modifier = Modifier.padding(16.dp),
            bannerImg = painterResource(id = R.drawable.login),
        )
    }
) {
    // ui element matchers
    private val emailField = hasText("EMAIL") and hasSetTextAction()
    private val passwordField = hasText("PASSWORD") and hasSetTextAction()
    private val loginButton =  isNotEnabled() and hasText("Login") and hasClickAction()
    private val enabledButton = isEnabled() and hasText("Login") and hasClickAction()
    private val noAccountText = hasText("Don't have an account?", substring = true) and hasClickAction()


    // tests
    @Test
    override fun uiElementsExist(){
        composeRule
            .onNode(emailField)
            .assertExists(errorMessageOnFail = "Missing email field")
        composeRule
            .onNode(passwordField)
            .assertExists(errorMessageOnFail = "Missing password field")
        composeRule
            .onNode(loginButton)
            .assertExists(errorMessageOnFail = "Missing login button")
        composeRule
            .onNode(noAccountText)
            .assertExists(errorMessageOnFail = "Missing no account text")
    }

    @Test
    fun loginButtonVisibility(){
        composeRule
            .onNode(emailField)
            .performTextInput("hello world")
        composeRule
            .onNode(enabledButton)
            .assertDoesNotExist()
        composeRule
            .onNode(passwordField)
            .performTextInput("hello world")
        composeRule
            .onNode(enabledButton)
            .assertExists()
    }
}