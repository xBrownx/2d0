package com.brownx.a2d0.todo.presenter.createTask

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.KeyboardArrowDown
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.brownx.a2d0.ui.components.CustomDropdown
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 6/06/2024
 */

@Composable
fun CreateTaskDialog(
    onExit: () -> Unit
) {

    val createTaskViewModel = hiltViewModel<CreateTaskViewModel>()
    val createTaskState by createTaskViewModel.createTaskState.collectAsState()

    Scaffold(
        topBar = {
            TopTitle(title = "ADD TASK")
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = softYellow,
                onClick = onExit
            ) {
                Icon(
                    imageVector = Icons.Default.KeyboardArrowDown,
                    tint = softGrey,
                    contentDescription = "floating_button"
                )
            }
        }

    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .background(softGrey)
                .fillMaxSize()
        ) {
            CustomDropdown(
                value = createTaskState.groupName,
                label = "GROUP",
                list = createTaskState.groupsList.map {
                    it.groupName.uppercase()
                },
                onSelect = {
                    createTaskViewModel.onEvent(
                        CreateTaskUiEvents.OnGroupNameChanged(
                            groupName = it.uppercase()
                        )
                    )
                }
            )
            CustomTextField(
                value = createTaskState.taskName,
                label = "TASK NAME"
            ) {
                createTaskViewModel.onEvent(
                    CreateTaskUiEvents.OnTaskNameChanged(
                        taskName = it.uppercase()
                    )
                )
            }
            CustomTextField(
                value = createTaskState.taskDesc,
                label = "DESC"
            ) {
                createTaskViewModel.onEvent(
                    CreateTaskUiEvents.OnTaskDescChanged(
                        taskDesc = it.uppercase()
                    )
                )
            }
            CustomTextField(
                value = createTaskState.dueDate,
                label = "DUE DATE"
            ) {
                createTaskViewModel.onEvent(
                    CreateTaskUiEvents.OnDueDateChanged(
                        dueDate = it.uppercase()
                    )
                )
            }
        }
    }
}