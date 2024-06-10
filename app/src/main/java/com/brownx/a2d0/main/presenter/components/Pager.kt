package com.brownx.a2d0.main.presenter.components

import android.widget.Toast
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import com.brownx.a2d0.calendar.presenter.CoreCalendarScreen
import com.brownx.a2d0.groups.presenter.CoreGroupsScreen
import com.brownx.a2d0.main.util.HomeNavControllers
import com.brownx.a2d0.todo.presenter.CoreTodoScreen

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CorePager(
    paddingValues: PaddingValues,
    pagerState: PagerState,
    navControllers: HomeNavControllers,
    onCreateGroup: () -> Unit
) {
    Column(
        modifier = Modifier.fillMaxSize()
    ) {
        HorizontalPager(
            state = pagerState,
            modifier = Modifier
                .fillMaxSize()
                .weight(1f),
            contentPadding = paddingValues,
            beyondBoundsPageCount = 2,

            ) { page ->

            when (page) {
                0 -> CoreCalendarScreen(navControllers.calendarNav)
                1 -> CoreGroupsScreen(
                    navController = navControllers.groupsNav,
                    onCreateGroup = onCreateGroup
                )
                2 -> CoreTodoScreen(navControllers.todoNav)
                3 -> {}
                4 -> {}
            }
        }
    }
}
