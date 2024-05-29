package com.brownx.a2d0.groups.presenter.group

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.tooling.preview.Preview
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.groups.presenter.groups.components.AddGroupButton
import com.brownx.a2d0.groups.presenter.groups.components.GroupListButton
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Preview
@Composable
fun GroupScreen() {

    val groupViewModel = hiltViewModel<GroupViewModel>()
    val groupState by groupViewModel.groupState.collectAsState()

    Scaffold(
        topBar = { TopTitle(title = "** GROUP NAME GOES HERE **") }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(softGrey)
        ) {
            Text(text = groupState.groupName)
            Text(text = groupState.groupOwner)
            Text(text = groupState.numberOfTasks)
            Text(text = groupState.numberOfTasksAssignedToMe)
        }
    }
}