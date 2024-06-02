package com.brownx.a2d0.core.presenter.components

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.PagerState
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import com.brownx.a2d0.calendar.presenter.CalendarScreen
import com.brownx.a2d0.groups.presenter.groups.GroupsScreen
import com.brownx.a2d0.profile.presenter.ProfileScreen
import com.brownx.a2d0.settings.presenter.SettingsScreen
import com.brownx.a2d0.todo.presenter.TodoScreen

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
@OptIn(ExperimentalFoundationApi::class)
@Composable
fun CorePager(
    paddingValues: PaddingValues,
    pagerState: PagerState,
    navController: NavHostController
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
                0 -> CalendarScreen()
                1 -> GroupsScreen(navController = navController)
                2 -> TodoScreen()
                3 -> ProfileScreen()
                4 -> SettingsScreen()
            }
        }
    }
}