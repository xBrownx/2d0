package com.brownx.a2d0.groups.presenter.groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import com.brownx.a2d0.groups.presenter.groups.components.AddGroupButton
import com.brownx.a2d0.groups.presenter.groups.components.GroupListButton
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.util.Screen
import timber.log.Timber

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun GroupsScreen() {
    val groupsViewModel = hiltViewModel<GroupsViewModel>()
    val groupsState by groupsViewModel.groupsState.collectAsState()


    Column(
        modifier = Modifier
            .fillMaxSize()
            .background(softGrey)
    ) {

        LazyColumn(
            modifier = Modifier.fillMaxSize(),
            verticalArrangement = Arrangement.spacedBy(0.dp)
        ) {
            items(groupsState.groupsList) { group ->
                GroupListButton(group) {

                }
            }

            item {
                AddGroupButton {

                }
            }
        }
    }
}
