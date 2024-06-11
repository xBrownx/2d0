package com.brownx.a2d0.main.presenter.components

import androidx.compose.animation.core.tween
import androidx.compose.foundation.ExperimentalFoundationApi

import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.pager.PagerState
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material3.Icon
import androidx.compose.material3.NavigationBar
import androidx.compose.material3.NavigationBarItem
import androidx.compose.material3.NavigationBarItemDefaults
import androidx.compose.runtime.Composable
import androidx.compose.runtime.State
import androidx.compose.runtime.getValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.brownx.a2d0.R
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softGrey
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
    scope: CoroutineScope,
    selectedTabIndex: State<Int>,
    pagerState: PagerState
) {

    val screenState by navController.currentBackStackEntryAsState()

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
        val isHome = screenState?.destination?.route == Screen.Home.Home.route
        BottomNavEnum.entries.forEachIndexed { index, currentTab ->
            NavigationBarItem(
                colors = NavigationBarItemDefaults.colors(
                    indicatorColor = softYellow.copy(alpha = 1f),
                    selectedIconColor = softBlue,
                    unselectedIconColor = softPink
                ),
                selected = selectedTabIndex.value == index && isHome,
                onClick = {
                    if (!isHome) {
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
                    if (currentTab.isResource) {
                        Icon(
                            modifier = Modifier
                                .size((30+currentTab.scale).dp),
                            painter = painterResource(id = currentTab.resource!!),
                            contentDescription = currentTab.label,

                        )
                    } else {
                        Icon(
                            modifier = Modifier
                                .size((30+currentTab.scale).dp),
                            imageVector = currentTab.imageVector!!,
                            contentDescription = currentTab.label,
                        )
                    }
                }
            )
        }
    }
}

enum class BottomNavEnum(
    val isResource: Boolean = false,
    val imageVector: ImageVector? = null,
    val resource: Int? = null,
    val label: String,
    val scale: Int = 4
) {
    Calendar(
        imageVector = Icons.Default.DateRange,
        label = Screen.Home.Calendar.route,
    ),
    Groups(
        isResource = true,
        resource = R.drawable.groups,
        label = Screen.Home.Groups.route,
    ),
    Todo(
        imageVector = Icons.AutoMirrored.Outlined.List,
        label = Screen.Home.Todo.route,
        scale = 10,
    ),
    Profile(
        isResource = true,
        resource = R.drawable.profile,
        label = Screen.Home.Profile.route,
        scale = 0,
    ),
    Settings(
        imageVector = Icons.Default.Settings,
        label = Screen.Home.Settings.route,
    )
}
