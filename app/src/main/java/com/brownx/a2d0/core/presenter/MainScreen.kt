package com.brownx.a2d0.core.presenter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
import androidx.compose.material.icons.filled.Done
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.FloatingActionButton
import androidx.compose.material3.Icon
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.brownx.a2d0.core.presenter.components.BottomNavBar
import com.brownx.a2d0.core.presenter.components.BottomNavEnum
import com.brownx.a2d0.core.presenter.components.CoreNav
import com.brownx.a2d0.ui.theme.green
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 23/05/2024
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun MainScreen(
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












