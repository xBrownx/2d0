package com.brownx.a2d0.main.presenter

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
import androidx.compose.material3.pulltorefresh.PullToRefreshContainer
import androidx.compose.material3.pulltorefresh.rememberPullToRefreshState
import androidx.compose.runtime.Composable
import androidx.compose.runtime.LaunchedEffect
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.derivedStateOf
import androidx.compose.runtime.getValue
import androidx.compose.runtime.remember
import androidx.compose.runtime.rememberCoroutineScope
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.input.nestedscroll.nestedScroll
import androidx.hilt.navigation.compose.hiltViewModel
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.brownx.a2d0.main.presenter.components.BottomNavBar
import com.brownx.a2d0.main.presenter.components.BottomNavEnum
import com.brownx.a2d0.main.presenter.components.CorePager
import com.brownx.a2d0.ui.theme.green
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen
import kotlinx.coroutines.delay

/**
 * @author Andrew Brown
 * created on 23/05/2024
 */

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    navController: NavHostController
) {
    val screenState by navController.currentBackStackEntryAsState()

    val scope = rememberCoroutineScope()
    val pagerState = rememberPagerState(
        pageCount = { BottomNavEnum.entries.size },
        initialPage = 1
    )
    val selectedTabIndex = remember { derivedStateOf { pagerState.currentPage } }

    val mainViewModel = hiltViewModel<MainViewModel>()
    val mainState by mainViewModel.mainState.collectAsState()
    val pullRefreshState = rememberPullToRefreshState()

    LaunchedEffect(pullRefreshState.isRefreshing) {
        if(pullRefreshState.isRefreshing) {
            delay(1500)
            pullRefreshState.endRefresh()
        }
    }

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
            val isCreateTask = screenState?.destination?.route == Screen.Home.CreateTask.route
            FloatingActionButton(
                containerColor = if(isCreateTask) green else softYellow,
                onClick = {
                    if (isCreateTask) navController.navigate(Screen.Home.List.route)
                    else navController.navigate(Screen.Home.CreateTask.route)
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
                .nestedScroll(pullRefreshState.nestedScrollConnection)
        ) {
            PullToRefreshContainer(
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.CenterHorizontally))
            CorePager(
                paddingValues = paddingValues,
                pagerState = pagerState,
                navController = navController
            )
        }
    }
}












