package com.brownx.a2d0.todo.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.todo.presenter.components.ListItemButton
import com.brownx.a2d0.todo.presenter.components.ListTopBar
import com.brownx.a2d0.ui.theme.softGrey

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun TodoScreen() {
    val todoViewModel = hiltViewModel<TodoViewModel>()
    val todoState by todoViewModel.todoState.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {
            ListTopBar()
        }
    ) { paddingValues ->

        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(softGrey)
        ) {

            LazyColumn(
                modifier = Modifier.fillMaxSize(),
                verticalArrangement = Arrangement.spacedBy(0.dp)
            ) {
                items(todoState.todoList) {task ->
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
}





