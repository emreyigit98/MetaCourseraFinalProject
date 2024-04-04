package com.emreyigit98.courserafinalproject.presentation.companent.button

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.unit.dp
import com.emreyigit98.courserafinalproject.R

@Composable
fun AppButton(
    modifier: Modifier = Modifier,
    onClick: () -> Unit,
    textTitle: String,
    enabled : Boolean
) {
    Button(
        onClick = onClick,
        modifier = modifier
            .fillMaxWidth(),
        colors = ButtonDefaults.buttonColors(
            containerColor = colorResource(id = R.color.primary_color_yellow)
        ),
        enabled = enabled,
        shape = RoundedCornerShape(5.dp)
    ) {
        Text(
            text = textTitle,
            color = Color.DarkGray
        )
    }
}