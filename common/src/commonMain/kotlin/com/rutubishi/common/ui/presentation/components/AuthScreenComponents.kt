package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.Image
import androidx.compose.foundation.background
import androidx.compose.foundation.clickable
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.ColumnScope
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.rememberScrollState
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.foundation.verticalScroll
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Build
import androidx.compose.material.icons.filled.Lock
import androidx.compose.material.icons.filled.Phone
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.layout.ContentScale
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.text.input.PasswordVisualTransformation
import androidx.compose.ui.text.input.VisualTransformation
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.text.withStyle
import androidx.compose.ui.unit.dp

@Composable
fun AuthBanner(
    painter: Painter,
    contentDescription: String? = null,
    modifier: Modifier = Modifier,
) {

    Image(
        modifier = modifier
            .fillMaxWidth(),
        painter = painter,
        contentDescription = contentDescription,
        contentScale = ContentScale.Crop
    )

}

@Composable
fun AuthTitle(
    text: String,
) {

    Text(
        text = text,
        modifier = Modifier
            .fillMaxWidth()
            .padding(vertical = 16.dp, horizontal = 16.dp),
        style = MaterialTheme.typography.displaySmall,
        fontWeight = FontWeight.Bold,
        color = MaterialTheme.colorScheme.onPrimaryContainer
    )

}

@Composable
fun AuthScreen(
    tabletMode: Boolean = false,
    modifier: Modifier = Modifier,
    title: String = "",
    bannerImg: Painter,
    bannerDescription: String? = null,
    content: @Composable ColumnScope.() -> Unit,
) {



    if (tabletMode) {

        Row(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = MaterialTheme.colorScheme.background)
        ) {

            AuthBanner(
                painter = bannerImg,
                contentDescription = bannerDescription,
                modifier = Modifier
                    .fillMaxHeight()
                    .fillMaxWidth(0.5f)
            )

            Column(
                modifier = modifier
                    .fillMaxHeight()
                    .verticalScroll(rememberScrollState()),
                verticalArrangement = Arrangement.Center
            ) {
                AuthTitle(
                    text = title
                )
                content()
            }

        }

    }else {
        Column(
            modifier = Modifier
                .fillMaxHeight()
                .background(color = MaterialTheme.colorScheme.background)
                .verticalScroll(rememberScrollState())
        ) {

            AuthBanner(
                painter = bannerImg,
                contentDescription = bannerDescription,
                modifier = Modifier
                    .height(350.dp)
            )

            AuthTitle(
                text = title
            )

            Column(modifier = modifier) {
                content()
            }

        }
    }

}


@Composable
fun AuthScreenItems(): Pair<(@Composable () -> Unit), (@Composable () -> Unit)> {

    return Pair(
        first = @Composable {

        },
        second = @Composable {

        }
    )
}

@Composable
@ExperimentalMaterial3Api
fun PasswordTextField(
    password: String,
    onPasswordChange: (String) -> Unit,
    passwordLeadingIcon: @Composable () -> Unit =
        { Icon(
            imageVector = Icons.Default.Lock,
            contentDescription = null) },
) {

    var showPassword by remember { mutableStateOf(false) }
    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        value = password,
        onValueChange = onPasswordChange,
        label = { Text(text = "Password") },
        leadingIcon = passwordLeadingIcon,
        trailingIcon = {
            IconButton(onClick = { showPassword = !showPassword }){
                Icon(
                    imageVector = Icons.Default.Build,
                    contentDescription = null
                )
            }
        },
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Password),
        visualTransformation = if (showPassword) VisualTransformation.None else PasswordVisualTransformation(),
    )
}

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmailTextField(
    email: String,
    onEmailChange: (String) -> Unit,
) {

    TextField(
        value = email,
        onValueChange = onEmailChange,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        label = { Text(text = "Full Name") },
        leadingIcon = { Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null) },
    )
}

@Composable
@ExperimentalMaterial3Api
fun NameTextField(
    name: String,
    onNameChange: (String) -> Unit,
    nameLeadingIcon: @Composable () -> Unit =
        { Icon(
            imageVector = Icons.Default.AccountCircle,
            contentDescription = null) },
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        value = name,
        onValueChange = onNameChange,
        label = { Text(text = "Full Name") },
        leadingIcon = nameLeadingIcon,
    )

}

@Composable
@ExperimentalMaterial3Api
fun PhoneTextField(
    phone: String,
    onPhoneChange: (String) -> Unit,
    phoneLeadingIcon: @Composable () -> Unit =
        { Icon(
            imageVector = Icons.Default.Phone,
            contentDescription = null) },
) {

    TextField(
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 8.dp),
        value = phone,
        onValueChange = onPhoneChange,
        label = { Text(text = "Phone Number") },
        leadingIcon = phoneLeadingIcon,
        keyboardOptions = KeyboardOptions(
            keyboardType = KeyboardType.Phone),
    )

}

@Composable
@ExperimentalMaterial3Api
fun AuthButton(
    text: String,
    onClick: () -> Unit,
    enabled: Boolean = true,
) {

    Button(
        onClick = onClick,
        modifier = Modifier
            .fillMaxWidth()
            .padding(top = 16.dp),
        enabled = enabled,
    ) {
        Text(
            text = text,
            modifier = Modifier
                .fillMaxWidth()
                .padding(4.dp),
            textAlign = TextAlign.Center,
            style = MaterialTheme.typography.bodyMedium,
            fontWeight = FontWeight.Bold,
        )
    }
}

@Composable
fun AuthHelperText(
    modifier: Modifier = Modifier,
    isSignUp: Boolean = false,
    onClick: () -> Unit,
) {

    Text(
        text = buildAnnotatedString {
            append(if (isSignUp) "Already have an account? " else "Don't have an account? ")
            withStyle(
                style = SpanStyle(
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            ){
                append("Sign ${if (isSignUp) "in" else "up"}")
            }
        },
        modifier = modifier
            .padding(top = 16.dp, bottom = 16.dp)
            .clickable { onClick() },
        textAlign = TextAlign.Center,
        style = MaterialTheme.typography.bodyLarge,
        color = MaterialTheme.colorScheme.tertiary,
    )

}
