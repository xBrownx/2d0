package com.brownx.a2d0.util

/**
 * @author Andrew Brown
 * created on 17/05/2024
 */
sealed class Screen(val route: String) {

    data object Core : Screen("core")

    data object Home : Screen("home") {
        data object Home : Screen("home_core")
        data object Calendar : Screen("calendar_core") {
            data object Calendar : Screen("calendar")
        }

        data object Groups : Screen("groups_core") {
            data object Groups : Screen("groups")
            data object Friends : Screen("friends")
            data object Group : Screen("group")
        }

        data object Todo : Screen("todo_core") {
            data object Today : Screen("today")
            data object Anytime : Screen("anytime")
            data object Upcoming : Screen("upcoming")

        }
        data object Profile : Screen("profile_core") {
            data object Profile: Screen("profile")
        }
        data object Settings : Screen("settings_core") {
            data object Settings : Screen("settings")
        }
    }

    data object Auth : Screen("auth") {
        data object Login : Screen("login")
        data object Register : Screen("register")
    }
}