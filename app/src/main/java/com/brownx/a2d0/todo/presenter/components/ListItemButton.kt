package com.brownx.a2d0.todo.presenter.components

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brownx.a2d0.ui.components.LetterIcon
import com.brownx.a2d0.ui.components.TextWithShadow
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softYellow

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@Composable
fun ListItemButton(
    title: String,
    leftIconLetter: Char = 'A',
    leftIconColour: Color = softYellow,
    leftIconTextColor: Color = softGrey,
    rightIconLetter: Char = '!',
    rightIconColour: Color = softYellow,
    rightIconTextColor: Color = softGrey,
    onClick: () -> Unit
) {
    Row(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp
            )
            .fillMaxWidth()
            .background(softBlue),
        verticalAlignment = Alignment.CenterVertically
    ) {
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.Start
        ) {
            LetterIcon(
                backgroundColour = leftIconColour,
                textColour = leftIconTextColor,
                letter = leftIconLetter)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            TextWithShadow(
                text = title,
                fontSize = 19.sp,
                modifier = Modifier,
                xOffset = -1f,
                yOffset = 1f)
        }
        Column(
            modifier = Modifier
                .weight(1f)
                .fillMaxWidth(),
            horizontalAlignment = Alignment.End
        ) {
            LetterIcon(
                backgroundColour = rightIconColour,
                textColour = rightIconTextColor,
                letter = rightIconLetter)
        }

    }
}