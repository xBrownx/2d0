package com.brownx.a2d0.util

/**
 * @author Andrew Brown
 * created on 17/05/2024
 */
sealed class Screen(val route: String) {
    data object Calendar : Screen("calendar")
    data object Groups : Screen("groups")
    data object List : Screen("list")
    data object Profile : Screen("profile")
    data object Settings : Screen("settings")
    data object CreateTask : Screen("create_task")
    data object CreateGroup: Screen("create_group")
    data object CoreScreen : Screen("core_screen")
}