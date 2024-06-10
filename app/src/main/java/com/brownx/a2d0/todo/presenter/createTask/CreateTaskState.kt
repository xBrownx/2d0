package com.brownx.a2d0.todo.presenter.createTask

import com.brownx.a2d0.main.domain.model.Group


/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
data class CreateTaskState(
    val isLoading: Boolean = false,

    val groupsList: List<Group> = listOf(),
    val groupName: String = "",
    val taskName: String = "",
    val taskDesc: String = "",
    val dueDate: String = "",
    val dueTime: String = "",
    val isRepeat: Boolean = false,
    val repeatFreq: Int = 0,
    val repeatUnit: String = ""
)