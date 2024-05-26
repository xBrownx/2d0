package com.brownx.a2d0.todo.presenter

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.padding
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.todo.presenter.components.ListItemButton
import com.brownx.a2d0.todo.presenter.components.ListTopBar
import com.brownx.a2d0.todo.presenter.components.TodoList
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softPink

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun TodoScreen(
    paddingValues: PaddingValues
) {
    val todoViewModel = hiltViewModel<TodoViewModel>()
    val todoState by todoViewModel.todoState.collectAsState()

    Scaffold(
        modifier = Modifier
            .padding(paddingValues),
        topBar = {
            ListTopBar()
        }
    ) { pv ->
        Column(
            modifier = Modifier
                .padding(pv)
                .fillMaxSize()
                .background(softGrey)
        ) {
            TodoList(
                todoViewModel = todoViewModel,
                todoState = todoState
            )
        }
    }
}





