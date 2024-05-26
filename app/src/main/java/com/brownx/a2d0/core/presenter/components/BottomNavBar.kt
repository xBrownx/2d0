package com.brownx.a2d0.core.presenter.components

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.automirrored.outlined.List
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.rounded.AccountCircle
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.navigation.NavHostController
import androidx.navigation.compose.currentBackStackEntryAsState
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softYellow
import com.brownx.a2d0.util.Screen

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun BottomNavBar(
    navController: NavHostController
) {
    BottomAppBar(
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
        actions = {
            Row(
                modifier = Modifier
                    .fillMaxWidth(),
                verticalAlignment = Alignment.CenterVertically,
                horizontalArrangement = Arrangement.SpaceAround,
            ) {
                CustomIconButton(
                    navController = navController,
                    screen = Screen.Calendar,
                    icon = Icons.Default.DateRange,
                    contentDescription = "calendar"
                )
                CustomIconButton(
                    navController = navController,
                    screen = Screen.Groups,
                    icon = Icons.Rounded.AccountCircle,
                    contentDescription = "groups"
                )
                CustomIconButton(
                    navController = navController,
                    screen = Screen.List,
                    icon = Icons.AutoMirrored.Outlined.List,
                    scale = 2.4f,
                    contentDescription = "list"
                )
                CustomIconButton(
                    navController = navController,
                    screen = Screen.Profile,
                    icon = Icons.Default.Person,
                    contentDescription = "profile"
                )
                CustomIconButton(
                    navController = navController,
                    screen = Screen.Settings,
                    icon = Icons.Default.Settings,
                    contentDescription = "settings"
                )
            }
        }
    )
}

@Composable
fun CustomIconButton(
    navController: NavHostController,
    screen: Screen,
    icon: ImageVector,
    contentDescription: String,
    scale: Float = 1.5f,
) {
    val navBackStackEntry by navController.currentBackStackEntryAsState()

    val tint = if(navBackStackEntry?.destination?.route == screen.route) {
        softOrange
    } else {
        Color.White
    }

    IconButton(
        onClick = { navController.navigate(screen.route) },
        modifier = Modifier
            .scale(scale)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}