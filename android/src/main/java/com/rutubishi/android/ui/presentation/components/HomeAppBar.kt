package com.rutubishi.android.ui.presentation.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material3.Icon
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.painter.Painter
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.rutubishi.android.R
import com.rutubishi.common.ui.presentation.components.AppBar
import com.rutubishi.common.ui.presentation.components.AppBarIcon

@Composable
fun HomeAppBar(
    greeting: String = "Good Morning",
    name: String = "Rutubishi",
) {

    AppBar(
        modifier = Modifier
            .fillMaxWidth()
            .padding(16.dp),
        leadingContent = {
            Column {
                Text(
                    text = greeting,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Normal
                )
                Spacer(
                    modifier = Modifier.padding(2.dp)
                )
                Text(
                    text = name,
                    style = MaterialTheme.typography.headlineSmall,
                    fontWeight = FontWeight.Bold
                )
            }
        },
        trailingContent = {
            Row {
                AppBarIcon(
                    painter = painterResource(id = R.drawable.ic_history),
                    contentDescription = "History",
                )
                Spacer(modifier = Modifier.padding(horizontal = 6.dp))
                AppBarIcon(
                    painter = painterResource(id = R.drawable.ic_notifications),
                    contentDescription = "Notifications",
                )
            }
        }
    )

}
