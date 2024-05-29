package com.brownx.a2d0.groups.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.border
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Icon
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.clip
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brownx.a2d0.ui.components.TextWithShadow
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softYellow

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Composable
fun GroupListButton(
   groupName: String
) {
    Row(
        modifier = Modifier

            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp
            )
            .fillMaxWidth()
            .background(
                color = softBlue,
                shape = RoundedCornerShape(8.dp)
            )
            .padding(8.dp),
        verticalAlignment = Alignment.CenterVertically,

    ) {
        Box(
            modifier = Modifier
                .fillMaxWidth(),
        ) {
            Icon(
                imageVector = Icons.Default.Star,
                contentDescription = "favourite",
                tint = softYellow
            )

            Column(
                modifier = Modifier
                    .fillMaxWidth(),
                horizontalAlignment = Alignment.CenterHorizontally
            ) {

                TextWithShadow(
                    text = groupName,
                    fontSize = 19.sp,
                    modifier = Modifier,
                    xOffset = -1f,
                    yOffset = 1f
                )
            }
        }
    }
}