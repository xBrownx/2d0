package com.brownx.a2d0.main.presenter

import androidx.compose.foundation.ExperimentalFoundationApi
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.pager.rememberPagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Add
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
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.main.presenter.components.BottomNavBar
import com.brownx.a2d0.main.presenter.components.BottomNavEnum
import com.brownx.a2d0.main.presenter.components.CorePager
import com.brownx.a2d0.main.util.HomeNavControllers
import com.brownx.a2d0.ui.theme.green
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.util.Screen
import kotlinx.coroutines.delay
import kotlinx.coroutines.launch

/**
 * @author Andrew Brown
 * created on 23/05/2024
 */

@OptIn(ExperimentalFoundationApi::class, ExperimentalMaterial3Api::class)
@Composable
fun HomeScreen(
    coreNavController: NavHostController,
    onShowCreateTask: () -> Unit,
    onCreateGroup: () -> Unit
) {

    val homeNavControllers = HomeNavControllers(
        calendarNav = rememberNavController(),
        groupsNav = rememberNavController(),
        todoNav = rememberNavController(),
        profileNav = rememberNavController(),
        settingsNav = rememberNavController()
    )

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
            mainViewModel.onEvent(
                MainUiEvents.LoadAllRemoteData
            )
            delay(1500)
            pullRefreshState.endRefresh()
        }
    }

    Scaffold(
        bottomBar = {
            BottomNavBar(
                navController = coreNavController,
                scope = scope,
                selectedTabIndex = selectedTabIndex,
                pagerState = pagerState
            )
        },
        floatingActionButton = {
            FloatingActionButton(
                containerColor = green ,
                onClick = onShowCreateTask
            ) {
                Icon(
                    imageVector = Icons.Filled.Add,
                    tint = softGrey,
                    contentDescription = "floating_button"
                )
            }
        }

    ) { paddingValues ->
        Box(
            modifier = Modifier
                .padding(paddingValues)
                .background(softGrey)
                .nestedScroll(pullRefreshState.nestedScrollConnection)
        ) {
            CorePager(
                paddingValues = paddingValues,
                pagerState = pagerState,
                navControllers = homeNavControllers,
                onCreateGroup = onCreateGroup
            )
            PullToRefreshContainer(
                state = pullRefreshState,
                modifier = Modifier.align(Alignment.TopCenter))
        }
    }
}












