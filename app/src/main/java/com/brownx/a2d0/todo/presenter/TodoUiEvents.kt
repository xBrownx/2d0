package com.brownx.a2d0.todo.presenter

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
sealed class TodoUiEvents() {

    data class OnSelectTask(
        val taskId: String
    ) : TodoUiEvents()
}