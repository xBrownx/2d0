package com.brownx.a2d0.groups.presenter.createGroup

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
import com.brownx.a2d0.todo.presenter.createTask.CreateTaskUiEvents
import com.brownx.a2d0.ui.components.CustomDropdown
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softYellow

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Composable
fun CreateGroupDialog(
    onExit: () -> Unit
) {
    val createGroupViewModel = hiltViewModel<CreateGroupViewModel>()
    val createGroupState by createGroupViewModel.createGroupState.collectAsState()

    Scaffold(
        topBar = {
            TopTitle(title = "CREATE GROUP")
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

            CustomTextField(
                value = createGroupState.groupName,
                label = "GROUP NAME"
            ) {
                createGroupViewModel.onEvent(
                    CreateGroupUiEvent.OnEditGroupName(it)
                )
            }
            CustomTextField(
                value = createGroupState.groupName,
                label = "DESCRIPTION"
            ) {
                createGroupViewModel.onEvent(
                    CreateGroupUiEvent.OnEditGroupName(it)
                )
            }
        }
    }
}