package com.brownx.a2d0.tasks.presenter
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.green
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun CreateTaskScreen(
    navController: NavHostController
) {
    val createTaskViewModel = hiltViewModel<CreateTaskViewModel>()
    val createTaskState by createTaskViewModel.createTaskState.collectAsState()

    Scaffold(
        modifier = Modifier,
        topBar = {
            TopTitle(title = "NEW TASK")
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor =  softOrange,
                onClick = { navController.navigate(Screen.Home.route) }
            ) {
                Icon(
                    imageVector = Icons.Default.Close,
                    tint = softGrey,
                    contentDescription = "floating_button"
                )
            }
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

