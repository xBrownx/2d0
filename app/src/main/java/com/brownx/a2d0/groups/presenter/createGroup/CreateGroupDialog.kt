package com.brownx.a2d0.groups.presenter.createGroup

import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.ui.components.CustomTextField

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Composable
fun CreateGroupDialog(

) {
    val createGroupViewModel = hiltViewModel<CreateGroupViewModel>()
    val createGroupState by createGroupViewModel.createGroupState.collectAsState()

    CustomTextField(
        value = createGroupState.groupName,
        label = "Group Name")
    {
        createGroupViewModel.onEvent(
            CreateGroupUiEvent.OnEditGroupName(it)
        )
    }
}