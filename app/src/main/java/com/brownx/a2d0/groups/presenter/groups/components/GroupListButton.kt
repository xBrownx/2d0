package com.brownx.a2d0.groups.presenter.groups.components

import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Star
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.semantics.SemanticsProperties.Text
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import com.brownx.a2d0.main.domain.model.Group
import com.brownx.a2d0.ui.components.TextWithShadow
import com.brownx.a2d0.ui.theme.softBlue
import com.brownx.a2d0.ui.theme.softYellow

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@Composable
fun GroupListButton(
    group: Group,
    onClick: () -> Unit
) {

    var isExpanded by remember {
        mutableStateOf(false)
    }

    Button(
        modifier = Modifier
            .padding(
                start = 16.dp,
                end = 16.dp,
                top = 8.dp
            )
            .fillMaxWidth(),
        shape = RoundedCornerShape(8.dp),
        colors = ButtonDefaults.buttonColors(
            containerColor = softBlue,
        ),
        onClick = {
            isExpanded = !isExpanded
        }
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
                horizontalAlignment = Alignment.CenterHorizontally,
                verticalArrangement = Arrangement.Center
            ) {

                TextWithShadow(
                    text = group.groupName.uppercase(),
                    fontSize = 19.sp,
                    modifier = Modifier,
                    xOffset = -1f,
                    yOffset = 1f
                )

                AnimatedVisibility(
                    modifier = Modifier.padding(vertical = 6.dp),
                    visible = isExpanded
                ) {
                    Column(
                        modifier = Modifier
                            .fillMaxWidth(),
                        horizontalAlignment = Alignment.Start
                    ) {

                        TextWithShadow(
                            text = "Owner: ${group.groupOwnerId}".uppercase(),
                            fontSize = 19.sp,
                            modifier = Modifier
                                .padding(vertical = 6.dp),
                            xOffset = -1f,
                            yOffset = 1f
                        )
                        TextWithShadow(
                            text = "Desc: ",
                            fontSize = 19.sp,
                            modifier = Modifier
                                .padding(vertical = 6.dp),
                            xOffset = -1f,
                            yOffset = 1f
                        )
                        TextWithShadow(
                            text = "Members: ",
                            fontSize = 19.sp,
                            modifier = Modifier
                                .padding(vertical = 6.dp),
                            xOffset = -1f,
                            yOffset = 1f
                        )
                        Row(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(vertical = 10.dp)
                        ) {
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                onClick = { /*TODO*/ }
                            ) {
                                Text("EDIT MEMBERS")
                            }
                            Spacer(modifier = Modifier.padding(6.dp))
                            Button(
                                modifier = Modifier
                                    .fillMaxWidth()
                                    .weight(1f),
                                onClick = { /*TODO*/ }
                            ) {
                                Text("NEW TASK")
                            }
                        }
                    }
                }
            }
        }
    }
}