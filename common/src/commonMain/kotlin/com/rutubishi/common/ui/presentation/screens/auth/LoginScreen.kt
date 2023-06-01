package com.rutubishi.common.ui.presentation.screens.auth

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.runtime.saveable.rememberSaveable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.dp
import com.rutubishi.common.data.graphql.GraphQLClient
import com.rutubishi.common.data.network.Resource
import com.rutubishi.common.data.repository.AuthRepository
import com.rutubishi.common.ui.presentation.components.*
import kotlinx.coroutines.flow.onEach

@Composable
@ExperimentalMaterial3Api
fun LoginScreen(
    tabletMode: Boolean = false,
    modifier: Modifier = Modifier,
    onNavigateToRegister: () -> Unit = {},
    bannerImg: Painter,
) {

    var email by rememberSaveable { mutableStateOf("") }

    AuthRepository(GraphQLClient.client).login("testMail@gmail.com", "12345678",/*"Bigman Bazzuu","123456"*/)
        .onEach { resource ->
            when (resource) {
                is Resource.Loading -> {
                    println("resource is loading: ${resource.data} \n" +
                            " Message: ${resource.message}")
                }
                is Resource.Success -> {
                    println("resource is success: ${resource.data?.token} \n Message: ${resource.message}")
                }
                is Resource.Error -> {
                    println("resource is error: ${resource.data} \n" +
                            " Message: ${resource.message}")
                }
            }
        }.collectAsState(initial = Resource.Loading())


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
            onClick = {},
            enabled = email.isNotEmpty(),
        )

        AuthHelperText(
            modifier = Modifier.align(Alignment.CenterHorizontally),
            isSignUp = false) { onNavigateToRegister() }


    }

}