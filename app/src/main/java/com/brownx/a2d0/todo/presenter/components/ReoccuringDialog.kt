package com.brownx.a2d0.todo.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.width
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.MutableIntState
import androidx.compose.runtime.MutableState
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.theme.softBlue

/**
 * @author Andrew Brown
 * created on 11/06/2024
 */

@Composable
fun ReoccurringDialog(
    modifier: Modifier = Modifier,
    showDialog: Boolean,
    frequencyValue: Int,
    unitValue: String,
    label: String,
    onDismiss: () -> Unit,
    onValueChange: (Int, String) -> Unit,
) {
    Column(
        modifier = modifier.fillMaxWidth(),
        verticalArrangement = Arrangement.Center,
        horizontalAlignment = Alignment.CenterHorizontally
    ) {
        TextField(
            modifier = modifier
                .padding(horizontal = 16.dp, vertical = 8.dp)
                .fillMaxWidth(),
            value = "$frequencyValue $unitValue",
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
            CustomDialog(
                onDismissRequest = onDismiss,
                confirmButton = {
                    TextButton(
                        onClick = {
                            onValueChange(
                                frequencyValue,
                                unitValue
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
                DialogContent(
                    frequencyValue = frequencyValue,
                    unitValue = unitValue,
                    onStateChange = { int, str ->
                        onValueChange(int, str)
                    },
                )
            }
        }
    }
}

@Composable
fun CustomDialog(
    title: String = "Choose Frequency",
    onDismissRequest: () -> Unit,
    confirmButton: @Composable (() -> Unit),
    dismissButton: @Composable (() -> Unit)? = null,
    containerColor: Color = MaterialTheme.colorScheme.surface,
    content: @Composable () -> Unit,
) {
    Dialog(
        onDismissRequest = onDismissRequest,
        properties = DialogProperties(
            usePlatformDefaultWidth = false
        ),
    ) {
        Surface(
            shape = MaterialTheme.shapes.extraLarge,
            tonalElevation = 6.dp,
            modifier = Modifier
                .width(IntrinsicSize.Min)
                .height(IntrinsicSize.Min)
                .background(
                    shape = MaterialTheme.shapes.extraLarge,
                    color = containerColor
                ),
            color = containerColor
        ) {
            Column(
                modifier = Modifier.padding(24.dp),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {
                Text(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(bottom = 20.dp),
                    text = title,
                    style = MaterialTheme.typography.labelMedium
                )
                content()
                Row(
                    modifier = Modifier
                        .height(40.dp)
                        .fillMaxWidth()
                ) {
                    Spacer(modifier = Modifier.weight(1f))
                    dismissButton?.invoke()
                    confirmButton()
                }
            }
        }
    }
}

@Composable
fun DialogContent(
    frequencyValue: Int,
    unitValue: String,
    onStateChange: (Int, String) -> Unit
) {
    Row() {
        CustomTextField(
            value = frequencyValue.toString(),
            label = ""
        ) {
            onStateChange(it.toInt(), unitValue)
        }
        CustomTextField(
            value = unitValue,
            label = ""
        ) {
            onStateChange(frequencyValue, it)
        }
    }
}

