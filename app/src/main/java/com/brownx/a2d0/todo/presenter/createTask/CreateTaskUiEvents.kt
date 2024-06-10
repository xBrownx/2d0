package com.brownx.a2d0.todo.presenter.createTask

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
sealed class CreateTaskUiEvents {

    data class OnGroupNameChanged(
        val groupName: String
    ) : CreateTaskUiEvents()

    data class OnTaskNameChanged(
        val taskName: String
    ) : CreateTaskUiEvents()

    data class OnTaskDescChanged(
        val taskDesc: String
    ) : CreateTaskUiEvents()

    data class OnDueDateChanged(
        val dueDate: String
    ) : CreateTaskUiEvents()

    data object OnSaveTask : CreateTaskUiEvents()

}