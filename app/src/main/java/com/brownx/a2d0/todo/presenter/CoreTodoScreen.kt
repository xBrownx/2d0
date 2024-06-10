package com.brownx.a2d0.todo.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.core.presenter.nav.TodoNav
import com.brownx.a2d0.todo.presenter.components.ListItemButton
import com.brownx.a2d0.todo.presenter.components.ListTopBar
import com.brownx.a2d0.ui.theme.softGrey

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun CoreTodoScreen(
    navController: NavHostController
) {

    var tabIndex by remember { mutableIntStateOf(0) }

    Scaffold(
        modifier = Modifier,
        topBar = {
            ListTopBar(
                tabs = listOf("2DAY", "ANYTIME", "UPCOMING",),
                tabIndex = tabIndex,
                onTabClick = {
                    tabIndex = it
                }
            )
        }
    ) { paddingValues ->
        TodoNav(
            navController = navController,
            paddingValues = paddingValues,
        )
    }
}





