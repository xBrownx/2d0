package com.brownx.a2d0

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AddCircle
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material.icons.filled.List
import androidx.compose.material.icons.filled.Person
import androidx.compose.material.icons.filled.Settings
import androidx.compose.material.icons.outlined.AddCircle
import androidx.compose.material.icons.outlined.List
import androidx.compose.material3.BottomAppBar
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.Scaffold
import androidx.compose.runtime.Composable
import androidx.compose.runtime.remember
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.composed
import androidx.compose.ui.draw.drawBehind
import androidx.compose.ui.draw.scale
import androidx.compose.ui.draw.shadow
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.graphics.Paint
import androidx.compose.ui.graphics.Path
import androidx.compose.ui.graphics.Shape
import androidx.compose.ui.graphics.drawscope.drawIntoCanvas
import androidx.compose.ui.graphics.toArgb
import androidx.compose.ui.graphics.vector.ImageVector
import androidx.compose.ui.platform.LocalDensity
import androidx.compose.ui.tooling.preview.Preview
import androidx.compose.ui.unit.Dp
import androidx.compose.ui.unit.dp
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softPink
import com.brownx.a2d0.ui.theme.softYellow

/**
 * @author Andrew Brown
 * created on 23/05/2024
 */

@Preview
@Composable
fun CoreScreen() {
    Scaffold(
        bottomBar = {
            BottomAppBar(
                modifier = Modifier
                    .fillMaxWidth(),
                containerColor = softBlue,
                actions = {
                    Row(
                        modifier = Modifier
                            .fillMaxWidth(),
                        verticalAlignment = Alignment.CenterVertically,
                        horizontalArrangement = Arrangement.SpaceAround,
                    ) {
                        CustomIconButton(
                            icon = Icons.Outlined.AddCircle,
                            contentDescription = "list") {}
                        CustomIconButton(
                            icon = Icons.Default.DateRange,
                            contentDescription = "list") {}
                        CustomIconButton(
                            icon = Icons.Outlined.List,
                            scale = 2.4f,
                            tint = softOrange,
                            contentDescription = "list") {}
                        CustomIconButton(
                            icon = Icons.Default.Person,
                            contentDescription = "list") {}
                        CustomIconButton(
                            icon = Icons.Default.Settings,
                            contentDescription = "list") {}
                    }
                }
            )
        }
    ) { paddingValues ->
        Row(
            modifier = Modifier
                .padding(paddingValues)
                .fillMaxSize()
                .background(softGrey)
        ) {

        }
    }
}

@Composable
fun CustomIconButton(
    icon: ImageVector,
    contentDescription: String,
    scale: Float = 1.5f,
    tint: Color = Color.White,
    onClick: () -> Unit,
) {
    IconButton(
        onClick = onClick,
        modifier = Modifier
            .scale(scale)
    ) {
        Icon(
            imageVector = icon,
            contentDescription = contentDescription,
            tint = tint
        )
    }
}
