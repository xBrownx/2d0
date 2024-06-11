package com.brownx.a2d0.todo.domain.usecase

import android.content.SharedPreferences
import com.brownx.a2d0.main.data.local.entity.TaskEntity
import com.brownx.a2d0.todo.presenter.createTask.CreateTaskState
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
class TaskStateToEntityUseCase @Inject constructor(
    private val prefs: SharedPreferences
) {

    operator fun invoke(taskState: CreateTaskState): TaskEntity {
        return TaskEntity(
            createdTimeStamp = taskState.createdTimeStamp,
            taskName = taskState.taskName,
            taskDescription = taskState.taskDescription,
            dueDate = taskState.dueDateInMillis,
            isRepeat = taskState.isRepeat,
            repeatFrequency = taskState.repeatFrequency,
            repeatFrequencyUnit = taskState.repeatFrequencyUnit,
            assignedBy = prefs.getString("username", null)!!
        )
    }

}