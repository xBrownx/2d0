package com.brownx.a2d0.core.presenter

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.viewModels
import com.brownx.a2d0.core.presenter.nav.CoreNav
import com.brownx.a2d0.ui.theme._2d0Theme
import dagger.hilt.android.AndroidEntryPoint

@AndroidEntryPoint
class MainActivity : ComponentActivity() {

    private val coreViewModel by viewModels<CoreViewModel>()

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        setContent {
            _2d0Theme {
                CoreNav(coreViewModel = coreViewModel)
            }
        }
    }
}

