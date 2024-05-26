package com.brownx.a2d0.todo.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brownx.a2d0.ui.components.TextWithShadow
import com.brownx.a2d0.ui.theme.softOrange

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Composable
fun HeadingBanner(
    title: String
) {
    Row(
        modifier = Modifier
            .padding(bottom = 8.dp)
            .shadow(10.dp)
            .fillMaxWidth()
            .background(softOrange)
            .padding(vertical = 10.dp),

        horizontalArrangement = Arrangement.Center,

        ) {
        TextWithShadow(
            modifier = Modifier,
            text = title,
            fontSize = 19.sp,
            xOffset = -2f,
            yOffset = 2f
        )
    }
}