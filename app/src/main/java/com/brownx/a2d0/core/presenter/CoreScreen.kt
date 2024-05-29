package com.brownx.a2d0.core.presenter

import androidx.compose.animation.core.EaseIn
import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.HorizontalPager
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Done
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.brownx.a2d0.calendar.presenter.CalendarScreen
import com.brownx.a2d0.core.presenter.components.BottomNavBar
import com.brownx.a2d0.core.presenter.components.BottomNavEnum
import com.brownx.a2d0.core.presenter.components.CorePager
import com.brownx.a2d0.profile.presenter.ProfileScreen
import com.brownx.a2d0.settings.presenter.SettingsScreen
import com.brownx.a2d0.groups.presenter.GroupsScreen
import com.brownx.a2d0.todo.presenter.TodoScreen
import com.brownx.a2d0.ui.theme.green
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softGreen
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softPink
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen
import kotlinx.coroutines.launch

/**
 * @author Andrew Brown
 * created on 23/05/2024
 */

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun CoreScreen(
    navController: NavHostController
) {
    val screenState by navController.currentBackStackEntryAsState()
    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        pageCount = { BottomNavEnum.entries.size },
        initialPage = 1
    )
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = navController,
                screenState = screenState,
                scope = scope,
                selectedTabIndex = selectedTabIndex,
                pagerState = pagerState
            )
        },
        floatingActionButton = {
            val isCreateTask = screenState?.destination?.route == Screen.CreateTask.route
            FloatingActionButton(
                containerColor = if(isCreateTask) green else softYellow,
                onClick = {
                    if (isCreateTask) navController.navigate(Screen.CoreScreen.route)
                    else navController.navigate(Screen.CreateTask.route)
                }
            ) {
                Icon(
                    imageVector = if(isCreateTask) Icons.Filled.Done else Icons.Filled.Add,
                    tint = softGrey,
                    contentDescription = "floating_button"
                )
            }
        }
    ) { paddingValues ->
        Column(
            modifier = Modifier
                .background(softGrey)
        ) {
            CoreNav(
                paddingValues = paddingValues,
                pagerState = pagerState,
                navController = navController
            )
        }
    }
}












