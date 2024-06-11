package com.brownx.a2d0.ui.components

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Button
import androidx.compose.material3.DatePicker
import androidx.compose.material3.DatePickerDialog
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.rememberDatePickerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.util.DateUtil

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
@RequiresApi(Build.VERSION_CODES.O)
@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun CustomDatePicker(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    value: String,
    label: String,
    onDismiss: () -> Unit,
    onValueChange: (Long) -> Unit,
) {

    val dateState = rememberDatePickerState()

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
            DatePickerDialog(
                onDismissRequest = onDismiss,
                confirmButton = {
                    Button(
                        onClick = {
                            dateState.selectedDateMillis?.let { onValueChange(it) }
                        }
                    ) {
                        Text(text = "OK")
                    }
                },
                dismissButton = {
                    Button(
                        onClick = onDismiss
                    ) {
                        Text(text = "ANYTIME")
                    }
                }
            ) {
                DatePicker(
                    state = dateState,
                    showModeToggle = true
                )
            }
        }

    }
}