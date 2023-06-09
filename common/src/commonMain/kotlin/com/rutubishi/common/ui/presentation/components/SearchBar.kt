package com.rutubishi.common.ui.presentation.components

import androidx.compose.foundation.Canvas
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.lazy.LazyRow
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.AssistChip
import androidx.compose.material3.AssistChipDefaults
import androidx.compose.material3.Card
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Brush
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.text.style.TextOverflow
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


@Composable
@ExperimentalMaterial3Api
fun SearchOption(
    modifier: Modifier = Modifier
        .padding(end = 8.dp)
        .height(32.dp),
    option: String,
    onOptionSelected: (String) -> Unit,
) {

    AssistChip(
        modifier = modifier,
        label = {
            Text(
                text = option,
                style = MaterialTheme.typography.bodyMedium,
                maxLines = 1,
                overflow = TextOverflow.Ellipsis,
                )},
        onClick = { onOptionSelected(option) },
        colors = AssistChipDefaults.assistChipColors(
            containerColor = MaterialTheme.colorScheme.tertiaryContainer,
            labelColor = MaterialTheme.colorScheme.onTertiaryContainer,
        ),
        shape = RoundedCornerShape(16.dp),
    )
}

@Composable
@ExperimentalMaterial3Api
fun SearchOptionsList(
    modifier: Modifier = Modifier
        .fillMaxWidth()
        .padding(4.dp),
    options: List<String>,
    onOptionSelected: (String) -> Unit,
){

    LazyRow(
        modifier = modifier,
        horizontalArrangement = Arrangement.spacedBy(4.dp),
        verticalAlignment = Alignment.CenterVertically,
    ) {

        items(options) { option ->
            SearchOption(
                option = option,
                onOptionSelected = onOptionSelected,
            )
        }

    }

}
