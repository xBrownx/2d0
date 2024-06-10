package com.brownx.a2d0.main.util

import androidx.navigation.NavController
import androidx.navigation.NavHostController

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
data class HomeNavControllers(
    val calendarNav: NavHostController,
    val groupsNav: NavHostController,
    val todoNav: NavHostController,
    val profileNav: NavHostController,
    val settingsNav: NavHostController
)
