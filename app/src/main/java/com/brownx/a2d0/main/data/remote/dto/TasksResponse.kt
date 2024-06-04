package com.brownx.a2d0.main.data.remote.dto

import com.brownx.a2d0.tasks.domain.model.TaskList

/**
 * @author Andrew Brown
 * created on 4/06/2024
 */
data class TasksResponse(
    val status: Boolean,
    val tasksList: TaskList
)