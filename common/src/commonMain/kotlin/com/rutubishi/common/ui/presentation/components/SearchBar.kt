package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.unit.dp

@Composable
@ExperimentalMaterial3Api
fun SearchBar(
    modifier: Modifier = Modifier,
    leadingIcon: Painter,
    leadingIconDescription: String,
    trailingIcon: Painter,
    trailingIconDescription: String,
    hint: String,
    onValueChange: (String) -> Unit,
    text: String,
) {

    Card(
        modifier = modifier,
    ) {

        TextField(
            modifier = Modifier
                .fillMaxSize(),
            value = text,
            onValueChange = onValueChange,
            leadingIcon = {
                AppIcon(
                    painter = leadingIcon,
                    contentDescription = leadingIconDescription,
                    ) },
            trailingIcon = {
                AppIcon(
                    painter = trailingIcon,
                    contentDescription = trailingIconDescription,
                )},
            colors = TextFieldDefaults.textFieldColors(
                focusedIndicatorColor = Color.Transparent,
                unfocusedIndicatorColor = Color.Transparent,
            ),
            placeholder = {
                Text(
                    text = hint,
                    style = MaterialTheme.typography.bodyMedium,
                ) },
        )

    }

}

@Composable
fun AppIcon(
    modifier: Modifier = Modifier
        .fillMaxHeight(),
    painter: Painter,
    contentDescription: String,
    tint: Color = MaterialTheme.colorScheme.onPrimaryContainer,
) {

    Icon(
        modifier = modifier,
        painter = painter,
        contentDescription = contentDescription,
        tint = tint,
    )

}