package com.brownx.a2d0.todo.presenter.createTask

import com.brownx.a2d0.main.domain.model.Group
import com.brownx.a2d0.main.domain.model.Task


/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
data class CreateTaskState(
    val isLoading: Boolean = false,

    val groupsList: List<Group> = listOf(),
    val groupName: String = "",

    val taskName: String = "",
    val taskDescription: String = "",
    val dueDateInMillis: Long = 0L,
    val dueTimeInMillis: Long = 0L,
    val isRepeat: Boolean = false,
    val repeatFrequency: Int = 0,
    val repeatFrequencyUnit: String = "",

    val dueDateString: String = "",
    val dueTimeString: String = "",
)

fun CreateTaskState.toTask(): Task {
    return Task(
        groupId = groupName,
        taskName = taskName,
        taskDescription = taskDescription,
        dueDate = dueDateInMillis,
        isRepeat = isRepeat,
        repeatFrequency = repeatFrequency,
        repeatFrequencyUnit = repeatFrequencyUnit,
        isComplete = false,
    )
}