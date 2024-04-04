package com.emreyigit98.courserafinalproject.presentation.companent.top_bar

import androidx.compose.foundation.Image
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Person
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.IconButtonDefaults
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.dp
import com.emreyigit98.courserafinalproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppTopBar(
    modifier: Modifier = Modifier,
    onClick: () -> Unit
) {
    Surface(color = colorResource(id = R.color.primary_highlight)) {
        TopAppBar(
            title = {
                Row(
                    verticalAlignment = Alignment.CenterVertically
                ) {
                    Image(
                        painter = painterResource(id = R.drawable.lemon_icon),
                        contentDescription = null,
                        modifier = modifier.size(24.dp)
                    )
                    Spacer(modifier = modifier.padding(horizontal = 10.dp))
                    Text(
                        text = "Little Lemon",
                        style = MaterialTheme.typography.bodyLarge,
                        color = colorResource(id = R.color.primary_dark)
                    )
                }
            },
            actions = {
                IconButton(
                    onClick = onClick,
                    colors = IconButtonDefaults.iconButtonColors(
                        contentColor = colorResource(id = R.color.primary_dark)
                    )
                ) {
                    Icon(imageVector = Icons.Default.Person, contentDescription = null)
                }
            }
        )
    }
}

@Preview
@Composable
fun AppTopBarPreview() {
    AppTopBar() {

    }
}