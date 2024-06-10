package com.brownx.a2d0.main.presenter

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.navigation.NavHostController
import androidx.navigation.compose.rememberNavController

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
@Composable
fun CoreHomeScreen(
    coreNavController: NavHostController
) {
    val homeNavController = rememberNavController()

    Box(
        modifier = Modifier
            .fillMaxSize()
    ) {
        HomeNav(
            navController = homeNavController
        )
    }

}