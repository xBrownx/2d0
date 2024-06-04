package com.brownx.a2d0.auth.presenter.components

import androidx.compose.foundation.text.ClickableText
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.SpanStyle
import androidx.compose.ui.text.buildAnnotatedString
import androidx.compose.ui.text.style.TextDecoration
import androidx.compose.ui.unit.sp
import com.brownx.a2d0.ui.theme.softOrange
import com.brownx.a2d0.ui.theme.softYellow

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
@Composable
fun BottomText(
    text: String,
    linkText: String,
    onClick: () -> Unit
) {
    val annotatedString = buildAnnotatedString {

        val startIndex = text.indexOf(linkText)
        val endIndex = startIndex + 4
        append(text)
        addStyle(
            style = SpanStyle(
                color = softYellow,
                fontSize = 18.sp
            ), start = 0, end = startIndex - 1
        )
        addStyle(
            style = SpanStyle(
                color = softOrange,
                fontSize = 18.sp,
                textDecoration = TextDecoration.Underline
            ), start = startIndex, end = endIndex
        )
        addStringAnnotation(
            tag = "link",
            annotation = "link",
            start = startIndex,
            end = endIndex
        )
    }
    ClickableText(
        modifier = Modifier,
        text = annotatedString,

        ) { offset ->
        annotatedString.getStringAnnotations(
            tag = "link",
            start = offset,
            end = offset
        ).firstOrNull()?.let {
            onClick()
        }

    }
}