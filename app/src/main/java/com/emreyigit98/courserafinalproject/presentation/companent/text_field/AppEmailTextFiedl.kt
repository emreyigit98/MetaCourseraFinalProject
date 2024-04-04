package com.emreyigit98.courserafinalproject.presentation.companent.text_field

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Email
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Text
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.unit.dp
import com.emreyigit98.courserafinalproject.R


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AppOutlinedTextField(
    modifier: Modifier = Modifier,
    onValueChange : (String) -> Unit,
    value : String,
    isError : Boolean
) {
    OutlinedTextField(
        value = value,
        onValueChange = onValueChange,
        trailingIcon = {
            Icon(imageVector = Icons.Default.Email, contentDescription = null)
        },
        placeholder = {
            Text(
                text = stringResource(id = R.string.text_place_holder)
            )
        },
        singleLine = true,
        isError = isError,
        modifier = modifier
            .fillMaxWidth()
            .padding(horizontal = 20.dp),
        colors = TextFieldDefaults.outlinedTextFieldColors(
            errorBorderColor = colorResource(id = R.color.error_red),
            focusedBorderColor = colorResource(id = R.color.primary_dark)
        )
    )
}