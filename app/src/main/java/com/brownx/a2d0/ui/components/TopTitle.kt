package com.brownx.a2d0.ui.components

import androidx.compose.foundation.layout.height
import androidx.compose.material3.CenterAlignedTopAppBar
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.TopAppBarDefaults
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.ui.theme.softOrange

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun TopTitle(
    title: String
) {
    CenterAlignedTopAppBar(
        modifier = Modifier.height(48.dp),
        title = {
            TextWithShadow(
                modifier = Modifier,
                text = title,
                xOffset = -1.5f,
                yOffset = 1.5f
            )
        },
        colors = TopAppBarDefaults.topAppBarColors(
            containerColor = softOrange
        ),
    )
}