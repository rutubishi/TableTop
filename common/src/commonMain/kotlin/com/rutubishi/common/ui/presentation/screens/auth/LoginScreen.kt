package com.rutubishi.common.ui.presentation.screens.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rutubishi.common.data.graphql.models.AuthOutput
import com.rutubishi.common.data.network.Resource
import com.rutubishi.common.ui.presentation.components.*

@Composable
@ExperimentalMaterial3Api
fun LoginScreen(
    tabletMode: Boolean = false,
    modifier: Modifier = Modifier,
    onNavigateToRegister: () -> Unit = {},
    onLogin: (String, String) -> Unit = { _, _ -> },
    screenState: Resource<AuthOutput?> = Resource.Success(null),
    loader: @Composable () -> Unit = {},
    bannerImg: Painter,
) {
    // field variables
    var email by rememberSaveable { mutableStateOf("") }
    var password by rememberSaveable { mutableStateOf("") }


    AuthScreen(
        tabletMode = tabletMode,
        modifier = modifier,
        title = "Login",
        bannerImg = bannerImg,
        screenState = screenState,
        loader = loader,
    ){

        EmailTextField(
            email = email,
            onEmailChange = { email = it },
        )

        PasswordTextField(
            password = password,
            onPasswordChange = { password = it },
        )

        Text(
            text = "Forgot password?",
            modifier = Modifier
                .fillMaxWidth()
                .padding(top = 8.dp),
            style = MaterialTheme.typography.bodyMedium,
            color = MaterialTheme.colorScheme.primary,
            textAlign = TextAlign.End
        )

        AuthButton(
            text = "Login",
            onClick = { onLogin(email, password) },
            enabled = (email.isNotEmpty() && password.isNotEmpty()) && (screenState !is Resource.Loading),
        )

        AuthHelperText(
            modifier = Modifier
                .align(Alignment.CenterHorizontally),
            isSignUp = false) { onNavigateToRegister() }

    }

}