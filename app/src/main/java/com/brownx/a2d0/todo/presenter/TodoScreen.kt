package com.brownx.a2d0.todo.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.main.domain.model.Task
import com.brownx.a2d0.todo.presenter.components.ListItemButton
import com.brownx.a2d0.ui.theme.softGrey

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun TodoScreen(
    paddingValues: PaddingValues,
    todoViewModel: TodoViewModel,
    todoList: List<Task>
) {
    Column(
        modifier = androidx.compose.ui.Modifier
            .padding(paddingValues)
            .fillMaxSize()
            .background(softGrey)
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            items(todoList) {task ->
                ListItemButton(
                    title = task.taskName,
                    leftIconLetter = task
                        .assignedTo?.first()
                        ?.userName?.first() ?: 'A'
                ) {
                    todoViewModel.onEvent(
                        TodoUiEvents.OnSelectTask(
                            task.taskId
                        )
                    )
                }
            }
        }
    }
}