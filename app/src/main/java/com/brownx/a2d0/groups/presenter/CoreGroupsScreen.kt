package com.brownx.a2d0.groups.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.todo.presenter.components.ListTopBar
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun CoreGroupsScreen(
    navController: NavHostController,
    onCreateGroup: () -> Unit
) {
    var tabIndex by remember { mutableIntStateOf(0) }
    Scaffold(
        modifier = Modifier,
        topBar = {
            ListTopBar(
                tabs = listOf("GROUPS", "FRIENDS"),
                tabIndex = tabIndex,
                onTabClick = {
                    tabIndex = it
                    when(it) {
                        0 -> { navController.navigate(Screen.Home.Groups.Groups.route) }
                        1 -> { navController.navigate(Screen.Home.Groups.Friends.route) }
                    }
                }
            )
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(softGrey)
        ) {
            GroupsNav(
                navController = navController,
                paddingValues = paddingValues,
                onCreateGroup = onCreateGroup
            )
        }
    }
}