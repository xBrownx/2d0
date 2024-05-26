package com.brownx.a2d0.core.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.navigation.compose.rememberNavController
import com.brownx.a2d0.ui.theme._2d0Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {
    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _2d0Theme {
                val navController = rememberNavController()
                CoreScreen(navController)
            }
        }
    }
}
