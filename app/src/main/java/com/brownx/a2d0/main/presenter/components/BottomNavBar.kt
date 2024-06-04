package com.brownx.a2d0.main.presenter.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavBackStackEntry
import androidx.navigation.NavHostController
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softPink
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen
import kotlinx.coroutines.CoroutineScope
import kotlinx.coroutines.launch

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@OptIn(ExperimentalFoundationApi::class)
@Composable
fun BottomNavBar(
    navController: NavHostController,
    screenState: NavBackStackEntry?,
    scope: CoroutineScope,
    selectedTabIndex: State<Int>,
    pagerState: PagerState
) {
    NavigationBar(
        modifier = Modifier
            .fillMaxWidth()
            .drawBehind {
                val strokeWidth = 30f
                val x = size.width
                drawLine(
                    color = softYellow,
                    start = Offset(0f, 0f), //(0,0) at top-left point of the box
                    end = Offset(x, 0f), //top-right point of the box
                    strokeWidth = strokeWidth
                )
            },
        containerColor = softBlue,
    ) {
        BottomNavEnum.entries.forEachIndexed { index, currentTab ->
            NavigationBarItem(
                selected =
                selectedTabIndex.value == index && screenState?.destination?.route ==
                        Screen.Home.route,
                onClick = {
                    if(screenState?.destination?.route != Screen.Home.route) {
                        navController.navigate(Screen.Home.route)
                    }
                    scope.launch {
                        pagerState.animateScrollToPage(
                            currentTab.ordinal,
                            animationSpec = tween(durationMillis = 250),
                        )
                    }
                },
                icon = {
                    Icon(
                        modifier = Modifier.scale(1.5f),
                        imageVector = currentTab.icon,
                        contentDescription = currentTab.label,
                        tint = softPink
                    )
                }
            )
        }
    }
}

enum class BottomNavEnum(
    val icon: ImageVector,
    val label: String,
) {
    Calendar(
        icon = Icons.Default.DateRange,
        label = Screen.Home.Calendar.route,
    ),
    Groups(
        icon = Icons.Rounded.AccountCircle,
        label = Screen.Home.Groups.route,
    ),
    Todo(
        icon = Icons.AutoMirrored.Outlined.List,
        label = Screen.Home.List.route,
    ),
    Profile(
        icon = Icons.Default.Person,
        label = Screen.Home.Profile.route,
    ),
    Settings(
        icon = Icons.Default.Settings,
        label = Screen.Home.Settings.route,
    )
}
