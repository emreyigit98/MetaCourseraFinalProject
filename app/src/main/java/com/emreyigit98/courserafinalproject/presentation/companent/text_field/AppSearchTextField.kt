package com.emreyigit98.courserafinalproject.presentation.companent.text_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.emreyigit98.courserafinalproject.R

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppSearchTextField(
    modifier: Modifier = Modifier,
    value : String,
    onValueChange : (String) -> Unit
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        singleLine = true,
        placeholder = {
             Text(
                 text = "Search"
             )
        },
        leadingIcon = {
            Icon(
                imageVector = Icons.Default.Search,
                contentDescription = null,
                tint = colorResource(id = R.color.primary_dark)
            )
        },
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 10.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            focusedBorderColor = colorResource(id = R.color.primary_dark),
            unfocusedBorderColor = colorResource(id = R.color.primary_dark),
            containerColor = colorResource(id = R.color.primary_highlight),
        )
    )
}