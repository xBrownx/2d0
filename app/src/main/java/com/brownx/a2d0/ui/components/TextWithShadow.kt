package com.brownx.a2d0.ui.components

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxHeight
import androidx.compose.foundation.layout.offset
import androidx.compose.foundation.layout.wrapContentHeight
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.alpha
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.text.style.TextAlign
import androidx.compose.ui.unit.TextUnit
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun TextWithShadow(
    text: String,
    textColour: Color = Color.White,
    fontSize: TextUnit = 16.sp,
    modifier: Modifier,
    xOffset: Float,
    yOffset: Float
) {
    Box {
        Text(
            text = text,
            color = Color.Black,
            fontWeight = FontWeight.Bold,
            fontSize = fontSize,
            modifier = modifier
                .offset(
                    x = (xOffset).dp,
                    y = yOffset.dp
                )
                .alpha(0.4f)
                .wrapContentHeight(align = Alignment.CenterVertically),
            textAlign = TextAlign.Center
        )
        Text(
            text = text,
            modifier = modifier
                .wrapContentHeight(align = Alignment.CenterVertically),
            textAlign = TextAlign.Center,
            fontSize = fontSize,
            fontWeight = FontWeight.Bold,
            color = textColour
        )
    }
}