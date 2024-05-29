package com.brownx.a2d0.todo.presenter.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material3.Tab
import androidx.compose.material3.TabRow
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableIntStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import com.brownx.a2d0.ui.components.TextWithShadow
import com.brownx.a2d0.ui.theme.softOrange

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun ListTopBar() {
    var tabIndex by remember { mutableIntStateOf(0) }
    val tabs = listOf("2DAY", "UPCOMING",)

    Column(modifier = Modifier.fillMaxWidth()) {
        TabRow(
            selectedTabIndex = tabIndex,
            containerColor = softOrange,
            contentColor = Color.White
        ) {
            tabs.forEachIndexed { index, title ->
                Tab(text = {
                        TextWithShadow(
                            modifier = Modifier,
                            text = title,
                            xOffset = -1.5f,
                            yOffset = 1.5f
                        )
                },
                    selected = tabIndex == index,
                    onClick = { tabIndex = index }
                )
            }
        }
        when (tabIndex) {
            0 -> {}
            1 -> {}
        }
    }

}