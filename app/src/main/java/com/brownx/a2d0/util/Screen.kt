package com.brownx.a2d0.util

/**
 * @author Andrew Brown
 * created on 17/05/2024
 */
sealed class Screen(val route: String) {

    data object Core : Screen("core")
    data object Home : Screen("home") {
        data object Calendar : Screen("calendar")
        data object Groups : Screen("groups_core") {
            data object Groups : Screen("groups")
            data object Group : Screen("group")
            data object CreateGroup : Screen("create_group")
        }
        data object List : Screen("list")
        data object Profile : Screen("profile")
        data object Settings : Screen("settings")
        data object CreateTask : Screen("create_task")
    }
    data object Auth : Screen("auth") {
        data object Login : Screen("login")
        data object Register : Screen("register")
    }
}