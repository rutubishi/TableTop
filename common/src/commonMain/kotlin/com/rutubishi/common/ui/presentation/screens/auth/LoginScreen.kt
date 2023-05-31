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
import com.rutubishi.common.ui.presentation.components.*

@Composable
@ExperimentalMaterial3Api
fun LoginScreen(
    tabletMode: Boolean = false,
    modifier: Modifier = Modifier,
    onNavigateToRegister: () -> Unit = {},
    bannerImg: Painter,
) {

    var email by rememberSaveable { mutableStateOf("") }

//    LaunchedEffect(Unit) {
//        val response = GraphQLClient.client.query(TestQuery()).execute()
//        println("response: ${response.data?.test}}")
//    }

    AuthScreen(
        tabletMode = tabletMode,
        modifier = modifier,
        title = "Login",
        bannerImg = bannerImg
    ){

        EmailTextField(
            email = email,
            onEmailChange = { email = it },
        )

        PasswordTextField(
            password = email,
            onPasswordChange = { email = it },
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
            onClick = { /*TODO*/ },
            enabled = email.isNotEmpty(),
        )

        AuthHelperText(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isSignUp = false) { onNavigateToRegister() }


    }

}