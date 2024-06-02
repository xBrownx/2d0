package com.brownx.a2d0.groups.presenter.groups

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.brownx.a2d0.groups.presenter.groups.components.AddGroupButton
import com.brownx.a2d0.groups.presenter.groups.components.GroupListButton
import com.brownx.a2d0.ui.components.TopTitle
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun GroupsScreen(
    navController: NavHostController
) {
    Scaffold(
        modifier = Modifier,
        topBar = {
            TopTitle(title = "GROUPS")
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(softGrey)
        ) {
            GroupListButton("PERSONAL") {
                navController.navigate(Screen.Group.route)
            }

            AddGroupButton {
                navController.navigate(Screen.CreateGroup.route)
            }
        }
    }
}

