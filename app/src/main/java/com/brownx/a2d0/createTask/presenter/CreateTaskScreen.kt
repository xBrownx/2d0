package com.brownx.a2d0.createTask.presenter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun CreateTaskScreen(
    paddingValues: PaddingValues
) {
    val createTaskViewModel = hiltViewModel<CreateTaskViewModel>()
    val createTaskState by createTaskViewModel.createTaskState.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopTitle(title = "NEW TASK")
        }
    ) { pv ->
        Column(
            modifier = Modifier
                .padding(pv)
                .fillMaxSize()
                .background(softGrey)
        ) {
            CustomTextField(
                value = createTaskState.taskName,
                label = "Title") {}
            CustomTextField(
                value = createTaskState.taskDescription,
                label = "Description") {}
            CustomTextField(
                value = createTaskState.dueDate,
                label = "Due Date") {}
            CustomTextField(
                value = createTaskState.taskGroup,
                label = "Group") {}
            CustomTextField(
                value = createTaskState.assignedTo,
                label = "Assign To") {}
        }
    }
}

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
        }
    )
}