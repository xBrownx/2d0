package com.brownx.a2d0.core.presenter

import androidx.compose.foundation.layout.Column
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import com.brownx.a2d0.calendar.presenter.CalendarScreen
import com.brownx.a2d0.profile.presenter.ProfileScreen
import com.brownx.a2d0.settings.presenter.SettingsScreen
import com.brownx.a2d0.core.presenter.components.BottomNavBar
import com.brownx.a2d0.createTask.presenter.CreateTaskScreen
import com.brownx.a2d0.groups.presenter.GroupsScreen
import com.brownx.a2d0.todo.presenter.TodoScreen
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 23/05/2024
 */

@Composable
fun CoreScreen(
    navController: NavHostController
) {
    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                onClick = {
                    navController.navigate(Screen.CreateTask.route)
                }
            ) {
                Icon(Icons.Filled.Add,"")
            }
        }
    ) { paddingValues ->
        Column {
            NavHost(
                navController = navController,
                startDestination = Screen.List.route,
            ) {
                composable(Screen.Calendar.route) { CalendarScreen(paddingValues = paddingValues) }
                composable(Screen.Groups.route) { GroupsScreen(paddingValues = paddingValues) }
                composable(Screen.List.route) { TodoScreen(paddingValues = paddingValues) }
                composable(Screen.Profile.route) { ProfileScreen(paddingValues = paddingValues) }
                composable(Screen.Settings.route) { SettingsScreen(paddingValues = paddingValues) }
                composable(Screen.CreateTask.route) { CreateTaskScreen(paddingValues = paddingValues) }
            }
        }
    }
}








