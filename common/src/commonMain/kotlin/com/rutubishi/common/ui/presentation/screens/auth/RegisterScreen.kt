package com.rutubishi.common.ui.presentation.screens.auth

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.rutubishi.common.ui.presentation.components.AuthButton
import com.rutubishi.common.ui.presentation.components.AuthHelperText
import com.rutubishi.common.ui.presentation.components.AuthScreen
import com.rutubishi.common.ui.presentation.components.EmailTextField
import com.rutubishi.common.ui.presentation.components.NameTextField
import com.rutubishi.common.ui.presentation.components.PasswordTextField
import com.rutubishi.common.ui.presentation.components.PhoneTextField

@Composable
@ExperimentalMaterial3Api
fun RegisterScreen(
    modifier: Modifier = Modifier,
    bannerImg: Painter,
) {

    var text by rememberSaveable { mutableStateOf("") }

    AuthScreen(
        modifier = modifier,
        pageName = "Register",
        title = "Register",
        bannerImg = bannerImg
    ) {

        EmailTextField(
            email = text,
            onEmailChange = { text = it },
        )

        NameTextField(
            name = text,
            onNameChange = { text = it },
        )

        PhoneTextField(
            phone = text,
            onPhoneChange = { text = it },
        )

        PasswordTextField(
            password = text,
            onPasswordChange = { text = it },
        )

        AuthButton(
            text = "Register",
            onClick = { /*TODO*/ },
            enabled = text.isNotEmpty(),
        )

        AuthHelperText(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            /*TODO()*/
        }

    }

}