package com.brownx.a2d0.core.presenter.nav

import androidx.compose.animation.AnimatedContentTransitionScope
import androidx.compose.animation.core.tween
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.navigation
import com.brownx.a2d0.todo.presenter.TodoScreen
import com.brownx.a2d0.todo.presenter.TodoState
import com.brownx.a2d0.todo.presenter.TodoViewModel
import com.brownx.a2d0.todo.presenter.createTask.CreateTaskDialog
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */

@Composable
fun TodoNav (
    navController: NavHostController,
    paddingValues: PaddingValues,
) {

    val todoViewModel = hiltViewModel<TodoViewModel>()
    val todoState by todoViewModel.todoState.collectAsState()

    NavHost(
        navController = navController,
        route = Screen.Home.Todo.route,
        startDestination = Screen.Home.Todo.Today.route
    ) {
        composable(
            route = Screen.Home.Todo.Today.route,
        ) {
            TodoScreen(
                paddingValues = paddingValues,
                todoViewModel = todoViewModel,
                todoList = todoState.todoToday
            )
        }
        composable(
            route = Screen.Home.Todo.Anytime.route,
        ) {
            TodoScreen(
                paddingValues = paddingValues,
                todoViewModel = todoViewModel,
                todoList = todoState.todoAnytime
            )
        }
        composable(
            route = Screen.Home.Todo.Upcoming.route,
        ) {
            TodoScreen(
                paddingValues = paddingValues,
                todoViewModel = todoViewModel,
                todoList = todoState.todoUpcoming
            )
        }
    }
}