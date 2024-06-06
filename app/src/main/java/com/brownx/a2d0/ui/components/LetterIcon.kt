package com.brownx.a2d0.ui.components

import androidx.compose.foundation.Canvas
import androidx.compose.material3.IconButton
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.geometry.Offset
import androidx.compose.ui.graphics.Color

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */

@Composable
fun LetterIcon(
    backgroundColour: Color,
    textColour: Color,
    letter: Char
) {
    IconButton(onClick = { /*TODO*/ }) {
        Canvas(
            modifier = Modifier
        ) {
            drawCircle(
                color = Color.Black.copy(alpha = 0.2f),
                radius = 50f,
                alpha = 1f,
                center = Offset(-3f, 3f)
            )
            drawCircle(
                color = backgroundColour,
                radius = 50f,
                alpha = 1f,
            )

        }
        TextWithShadow(
            modifier = Modifier,
            text = letter.toString(),
            textColour = textColour,
            xOffset = -1f,
            yOffset = 1f
        )
    }
}