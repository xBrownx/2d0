package com.brownx.a2d0.todo.presenter.components

import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.rememberLazyListState
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.todo.presenter.TodoState
import com.brownx.a2d0.todo.presenter.TodoViewModel

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun TodoList(
    todoViewModel: TodoViewModel,
    todoState: TodoState
) {
    val listState = rememberLazyListState()

    LazyColumn(
        contentPadding = PaddingValues(
            start = 6.dp,
            end = 6.dp,
            top = 6.dp,
            bottom = 6.dp
        ),
        state = listState
    ) {
        items(
            items = mutableListOf("", ""),
            itemContent = {
//                ListItemButton(
//                    title = ,
//                    leftIconLetter = ,
//                    leftIconColour = ,
//                    leftIconTextColor = ,
//                    rightIconLetter = ,
//                    rightIconColour = ,
//                    rightIconTextColor =
//                )
            }
        )
    }
}