package com.brownx.a2d0.ui.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.ui.theme.softBlue

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
@Composable
fun CustomTextField(
    value: String,
    label: String,
    onValueChange: (String) -> Unit
) {
    TextField(
        modifier = Modifier
            .padding(horizontal = 16.dp, vertical = 8.dp)
            .fillMaxWidth(),
        value = value,
        onValueChange = onValueChange,
        label = {
            Text(label)
        },
        colors = TextFieldDefaults.colors(
            unfocusedContainerColor = softBlue,
            focusedContainerColor = softBlue,
            focusedTextColor = Color.White,
            unfocusedTextColor = Color.White,
            focusedLabelColor = Color.White,
            unfocusedLabelColor = Color.White,
            cursorColor = Color.White
        ),
    )
}