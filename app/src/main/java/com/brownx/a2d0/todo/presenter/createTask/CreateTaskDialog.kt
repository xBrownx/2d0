package com.brownx.a2d0.todo.presenter.createTask

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.compose.animation.AnimatedVisibility
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.IntrinsicSize
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.DateRange
import androidx.compose.material3.Button
import androidx.compose.material3.Checkbox
import androidx.compose.material3.CheckboxDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextButton
import androidx.compose.runtime.Composable
import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.res.painterResource
import androidx.compose.ui.unit.dp
import androidx.compose.ui.window.Dialog
import androidx.compose.ui.window.DialogProperties
import androidx.hilt.navigation.compose.hiltViewModel
import com.brownx.a2d0.R
import com.brownx.a2d0.todo.presenter.components.ReoccurringDialog
import com.brownx.a2d0.ui.components.CustomDatePicker
import com.brownx.a2d0.ui.components.CustomDropdown
import com.brownx.a2d0.ui.components.CustomTextField
import com.brownx.a2d0.ui.components.CustomTimePicker
import com.brownx.a2d0.ui.components.TextWithShadow
import com.brownx.a2d0.ui.theme.softGrey
import com.brownx.a2d0.ui.theme.softOrange


/**
 * @author Andrew Brown
 * created on 6/06/2024
 */

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun CreateTaskDialog(
    isShow: Boolean,
    title: String = "NEW TASK",
    containerColor: Color = MaterialTheme.colorScheme.surface,
    onConfirm: () -> Unit,
    onDismiss: () -> Unit,
) {

    val createTaskViewModel = hiltViewModel<CreateTaskViewModel>()
    val createTaskState by createTaskViewModel.createTaskState.collectAsState()

    if (isShow) {
        Dialog(
            onDismissRequest = onDismiss,
            properties = DialogProperties(
                usePlatformDefaultWidth = false,
            ),
        ) {
            Surface(
                shape = MaterialTheme.shapes.extraLarge,
                tonalElevation = 6.dp,
                modifier = Modifier
                    .padding(horizontal = 10.dp)
                    .height(IntrinsicSize.Max)
                    .background(
                        shape = MaterialTheme.shapes.extraLarge,
                        color = containerColor
                    )
                    ,
                color = containerColor
            ) {
                Column(
                    modifier = Modifier.padding(0.dp),
                    horizontalAlignment = Alignment.CenterHorizontally
                ) {
                    Row(
                        modifier = Modifier
                            .background(softOrange)
                            .fillMaxWidth()
                            .height(50.dp),
                        horizontalArrangement = Arrangement.Center,
                        verticalAlignment = Alignment.CenterVertically
                    ) {
                        TextWithShadow(
                            modifier = Modifier
                                .fillMaxWidth()
                                .padding(5.dp),
                            text = title
                        )
                    }

                    DialogContent(
                        createTaskViewModel = createTaskViewModel,
                        createTaskState = createTaskState
                    )
                    Row(
                        modifier = Modifier
                            .height(50.dp)
                            .fillMaxWidth()
                            .background(softOrange)
                    ) {
                        Spacer(modifier = Modifier.weight(1f))

                        TextButton(
                            onClick = onDismiss
                        ) {
                            Text(
                                text = "Cancel",
                                color = Color.White
                            )
                        }
                        TextButton(
                            onClick = onConfirm
                        ) {
                            Text(
                                text = "OK",
                                color = Color.White
                            )
                        }
                    }
                }
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DialogContent(
    createTaskViewModel: CreateTaskViewModel,
    createTaskState: CreateTaskState
) {
    Column(
        modifier = Modifier
            .background(softGrey)
            .padding(vertical = 16.dp)
    ) {
        CustomDropdown(
            value = createTaskState.groupName,
            label = "GROUP",
            list = createTaskState.groupsList.map {
                it.groupName.uppercase()
            },
            onSelect = {
                createTaskViewModel.onEvent(
                    CreateTaskUiEvents.OnGroupNameChanged(
                        groupName = it.uppercase()
                    )
                )
            }
        )
        CustomTextField(
            value = createTaskState.taskName,
            label = "TITLE"
        ) {
            createTaskViewModel.onEvent(
                CreateTaskUiEvents.OnTaskNameChanged(
                    taskName = it.uppercase()
                )
            )
        }
        CustomTextField(
            value = createTaskState.taskDescription,
            label = "DESC"
        ) {
            createTaskViewModel.onEvent(
                CreateTaskUiEvents.OnTaskDescChanged(
                    taskDesc = it.uppercase()
                )
            )
        }
        DueDateRow(
            createTaskViewModel = createTaskViewModel,
            createTaskState = createTaskState
        )
        DueTimeRow(
            createTaskViewModel = createTaskViewModel,
            createTaskState = createTaskState
        )
        ReoccurringRow(
            createTaskViewModel = createTaskViewModel,
            createTaskState = createTaskState
        )
        Button(
            onClick = { 
                createTaskViewModel.onEvent(
                    CreateTaskUiEvents.OnSaveTask
                )
            }
        ) {
            Text(text = "SUBMIT")
        }

    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DueDateRow(
    createTaskViewModel: CreateTaskViewModel,
    createTaskState: CreateTaskState
) {

    var showDialog by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = !isChecked) {
            Checkbox(
                modifier = Modifier
                    .padding(start = 16.dp),
                checked = isChecked,
                colors = CheckboxDefaults.colors(
                    checkedColor = softOrange,
                    uncheckedColor = softOrange
                ),
                onCheckedChange = {
                    isChecked = !isChecked
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            CustomDatePicker(
                showDialog = showDialog,
                value = createTaskState.dueDateString,
                label = "DUE DATE",
                onDismiss = {
                    createTaskViewModel.onEvent(
                        CreateTaskUiEvents.OnDueDateChanged(
                            dueDateMillis = -1
                        )
                    )
                    showDialog = false
                    isChecked = false
                },
            ) {
                createTaskViewModel.onEvent(
                    CreateTaskUiEvents.OnDueDateChanged(
                        dueDateMillis = it
                    )
                )
                showDialog = false
            }
        }
        AnimatedVisibility(visible = isChecked) {
            IconButton(
                modifier = Modifier
                    .padding(end = 16.dp),
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .padding(0.dp),
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "calendar",
                    tint = softOrange
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun DueTimeRow(
    createTaskViewModel: CreateTaskViewModel,
    createTaskState: CreateTaskState
) {

    var showDialog by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = !isChecked) {
            Checkbox(
                modifier = Modifier
                    .padding(start = 16.dp),
                checked = isChecked,
                colors = CheckboxDefaults.colors(
                    checkedColor = softOrange,
                    uncheckedColor = softOrange
                ),
                onCheckedChange = {
                    isChecked = !isChecked
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            CustomTimePicker(
                showDialog = showDialog,
                value = createTaskState.dueTimeString,
                label = "DUE TIME",
                onDismiss = {
                    createTaskViewModel.onEvent(
                        CreateTaskUiEvents.OnDueTimeChanged(
                            hour = -1,
                            minute = -1,
                        )
                    )
                    isChecked = false
                    showDialog = false
                },
            ) { hour, minute ->
                createTaskViewModel.onEvent(
                    CreateTaskUiEvents.OnDueTimeChanged(
                        hour = hour,
                        minute = minute,
                    )
                )
                showDialog = false
            }
        }
        AnimatedVisibility(visible = isChecked) {
            IconButton(
                modifier = Modifier
                    .padding(end = 16.dp),
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .padding(0.dp),
                    painter = painterResource(id = R.drawable.clock),
                    contentDescription = "clock",
                    tint = softOrange
                )
            }
        }
    }
}

@RequiresApi(Build.VERSION_CODES.O)
@Composable
fun ReoccurringRow(
    createTaskViewModel: CreateTaskViewModel,
    createTaskState: CreateTaskState
) {
    var showDialog by remember { mutableStateOf(false) }
    var isChecked by remember { mutableStateOf(false) }
    Row(
        modifier = Modifier
            .fillMaxWidth()
            .height(IntrinsicSize.Min),
        horizontalArrangement = Arrangement.Center,
        verticalAlignment = Alignment.CenterVertically
    ) {
        AnimatedVisibility(visible = !isChecked) {
            Checkbox(
                modifier = Modifier
                    .padding(start = 16.dp),
                checked = isChecked,
                colors = CheckboxDefaults.colors(
                    checkedColor = softOrange,
                    uncheckedColor = softOrange
                ),
                onCheckedChange = {
                    isChecked = !isChecked
                }
            )
        }
        Column(
            modifier = Modifier
                .weight(1f)
        ) {
            ReoccurringDialog(
                showDialog = showDialog,
                frequencyValue = createTaskState.repeatFrequency,
                unitValue = createTaskState.repeatFrequencyUnit,
                label = "DUE DATE",
                onDismiss = {
                    createTaskViewModel.onEvent(
                        CreateTaskUiEvents.OnDueDateChanged(
                            dueDateMillis = -1
                        )
                    )
                    showDialog = false
                    isChecked = false
                },
            ) { int, str ->
//                createTaskViewModel.onEvent(
//                    CreateTaskUiEvents.OnDueDateChanged(
//                        dueDateMillis = it
//                    )
//                )
//
                showDialog = false
            }
        }
        AnimatedVisibility(visible = isChecked) {
            IconButton(
                modifier = Modifier
                    .padding(end = 16.dp),
                onClick = {
                    showDialog = true
                }
            ) {
                Icon(
                    modifier = Modifier
                        .size(32.dp)
                        .padding(0.dp),
                    imageVector = Icons.Filled.DateRange,
                    contentDescription = "calendar",
                    tint = softOrange
                )
            }
        }
    }
}
