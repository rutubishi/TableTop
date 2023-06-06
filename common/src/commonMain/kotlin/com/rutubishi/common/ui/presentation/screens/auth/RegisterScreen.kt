package com.rutubishi.common.ui.presentation.screens.auth

import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import com.rutubishi.common.data.graphql.models.AuthOutput
import com.rutubishi.common.data.network.Resource
import com.rutubishi.common.ui.presentation.components.*

@Composable
@ExperimentalMaterial3Api
fun RegisterScreen(
    modifier: Modifier = Modifier,
    tabletMode: Boolean = false,
    onNavigateToLogin: () -> Unit = {},
    onRegisterSuccess: () -> Unit = {},
    onRegister: (String, String, String, String) -> Unit = { _, _, _, _ -> },
    screenState: Resource<AuthOutput?> = Resource.Idle(null),
    loader: @Composable () -> Unit = {},
    bannerImg: Painter,
) {

    var email by rememberSaveable { mutableStateOf("") }
    var name by rememberSaveable { mutableStateOf("") }
    var phone by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }

    LaunchedEffect(screenState){
        if (screenState is Resource.Success) {
            onRegisterSuccess()
        }
    }

    AuthScreen(
        tabletMode = tabletMode,
        modifier = modifier,
        title = "Register",
        bannerImg = bannerImg,
        screenState = screenState,
        loader = loader,
    ) {

        EmailTextField(
            email = email,
            onEmailChange = { email = it },
        )

        NameTextField(
            name = name,
            onNameChange = { name = it },
        )

        PhoneTextField(
            phone = phone,
            onPhoneChange = { phone = it },
        )

        PasswordTextField(
            password = password,
            onPasswordChange = { password = it },
        )

        AuthButton(
            text = "Register",
            onClick = { onRegister(email, password, name, phone) },
            enabled = email.isNotEmpty()
                    && password.isNotEmpty()
                    && name.isNotEmpty()
                    && phone.isNotEmpty()
        )

        AuthHelperText(
            modifier = Modifier
                .align(Alignment.CenterHorizontally)
        ) {
            onNavigateToLogin()
        }

    }

}