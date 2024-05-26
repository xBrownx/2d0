package com.brownx.a2d0.createTask.presenter

import androidx.lifecycle.ViewModel
import com.brownx.a2d0.todo.presenter.TodoState
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@HiltViewModel
class CreateTaskViewModel @Inject constructor(

) : ViewModel() {

    private val _createTaskState = MutableStateFlow(CreateTaskState())
    val createTaskState = _createTaskState.asStateFlow()

}