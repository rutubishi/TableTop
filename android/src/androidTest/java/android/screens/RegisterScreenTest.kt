package android.screens

import android.fixtures.AppComposeTest
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.test.*
import androidx.compose.ui.unit.dp
import androidx.test.ext.junit.runners.AndroidJUnit4
import com.rutubishi.android.R
import com.rutubishi.common.ui.presentation.screens.auth.RegisterScreen
import org.junit.Test
import org.junit.runner.RunWith

@ExperimentalMaterial3Api
class RegisterScreenTest :
    AppComposeTest(
        content = {
            RegisterScreen(
                modifier = Modifier.padding(16.dp),
                bannerImg = painterResource(id = R.drawable.register),
            )
        }
    ) {
    // ui element matchers
    private val emailField = hasText("EMAIL") and hasSetTextAction()
    private val passwordField = hasText("PASSWORD") and hasSetTextAction()
    private val nameField = hasText("NAME") and hasSetTextAction()
    private val phoneField = hasText("PHONE") and hasSetTextAction()
    private val registerButton =  isNotEnabled() and hasText("Register") and hasClickAction()
    private val enabledButton = isEnabled() and hasText("Register") and hasClickAction()
    private val alreadyHaveAccountText = hasText("Already have an account?", substring = true) and hasClickAction()

    @Test
    override fun uiElementsExist(){
        composeRule
            .onNode(emailField)
            .assertExists(errorMessageOnFail = "Missing email field")
        composeRule
            .onNode(passwordField)
            .assertExists(errorMessageOnFail = "Missing password field")
        composeRule
            .onNode(nameField)
            .assertExists(errorMessageOnFail = "Missing name field")
        composeRule
            .onNode(phoneField)
            .assertExists(errorMessageOnFail = "Missing phone field")
        composeRule
            .onNode(registerButton)
            .assertExists(errorMessageOnFail = "Missing register button")
        composeRule
            .onNode(alreadyHaveAccountText)
            .assertExists(errorMessageOnFail = "Missing already have account text")
    }

    @Test
    fun registerButtonIsEnabledWhenAllFieldsAreFilled() {

        composeRule
            .onNode(emailField)
            .performTextInput("mail@mail.com")
        btnAssertion()
        composeRule
            .onNode(passwordField)
            .performTextInput("password")
        btnAssertion()
        composeRule
            .onNode(nameField)
            .performTextInput("name")
        btnAssertion()
        composeRule
            .onNode(phoneField)
            .performTextInput("1234567890")
        btnAssertion(true)
    }


    private fun btnAssertion(enabled: Boolean = false){
        if(!enabled)
            composeRule
                .onNode(enabledButton)
                .assertDoesNotExist()
        else
            composeRule
                .onNode(enabledButton)
                .assertExists(errorMessageOnFail = "Register button is not enabled")

    }


}