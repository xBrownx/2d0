package com.brownx.a2d0.todo.presenter

import com.brownx.a2d0.main.domain.model.Task
import com.brownx.a2d0.todo.util.TaskSortType

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
data class TodoState(
    val isLoading: Boolean = false,

    val taskSortType: TaskSortType = TaskSortType.DUE_TODAY,
    val todoList: List<Task> = listOf(),
)