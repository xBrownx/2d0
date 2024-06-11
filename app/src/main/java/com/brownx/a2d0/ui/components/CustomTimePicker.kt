package com.brownx.a2d0.ui.components


import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TimePicker
import androidx.compose.material3.rememberTimePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.ui.theme.softBlue

/**
 * @author Andrew Brown
 * created on 11/06/2024
 */
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomTimePicker(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    value: String,
    label: String,
    onDismiss: () -> Unit,
    onValueChange: (Int, Int) -> Unit,
) {

    val timeState = rememberTimePickerState()

    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            value = value,
            onValueChange = {

            },
            label = {
                Text(label)
            },
            readOnly = true,
            enabled = false,
            colors = TextFieldDefaults.colors(
                unfocusedContainerColor = softBlue,
                focusedContainerColor = softBlue,
                focusedTextColor = Color.White,
                unfocusedTextColor = Color.White,
                focusedLabelColor = Color.White,
                unfocusedLabelColor = Color.White,
                cursorColor = Color.White,
                disabledTextColor = Color.White,
                disabledLabelColor = Color.White,
                disabledContainerColor = softBlue
            ),
        )
        if (showDialog) {
            TimePickerDialog(
                onDismissRequest = onDismiss,
                confirmButton = {
                    TextButton(
                        onClick = {
                            onValueChange(
                                timeState.hour,
                                timeState.minute
                            )
                        }
                    ) {
                        Text("OK")
                    }
                },
                dismissButton = {
                    TextButton(
                        onClick = onDismiss
                    ) {
                        Text("ANYTIME")
                    }
                }
            ) {
                TimePicker(state = timeState)
            }
        }
    }
}