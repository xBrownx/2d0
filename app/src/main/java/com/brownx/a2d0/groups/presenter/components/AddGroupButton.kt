package com.brownx.a2d0.groups.presenter.components

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.Button
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Composable
fun AddGroupButton() {
    Button(
        modifier = Modifier
            .padding(
                horizontal = 16.dp,
                vertical = 8.dp
            )
            .fillMaxWidth(),
        onClick = { /*TODO*/ }
    ) {
        Icon(
            imageVector = Icons.Default.Add,
            contentDescription = "add_task"
        )
    }
}