package com.brownx.a2d0.todo.presenter

import androidx.lifecycle.MediatorLiveData
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.tasks.data.local.TaskEntity
import com.brownx.a2d0.tasks.data.repository.TaskRepository
import com.brownx.a2d0.todo.util.SortType
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 26/05/2024
 */
@HiltViewModel
class TodoViewModel @Inject constructor (
    private val taskRepository: TaskRepository
) : ViewModel() {

    private val _todoState = MutableStateFlow(TodoState())
    val todoState = _todoState.asStateFlow()

    private val tasksSortedByDate = taskRepository.getAssignedTaskSortedByDueDate()
    private val tasksSortedByGroup = taskRepository.getTasksSortedByGroup("")
    private val tasks = MediatorLiveData<List<TaskEntity>>()
    private var sortType = SortType.DUE_DATE

    init {
        tasks.addSource(tasksSortedByDate) { result ->
            if(sortType == SortType.DUE_DATE) {
                result?.let { tasks.value = it }
            }
        }
        tasks.addSource(tasksSortedByGroup) {result ->
            if(sortType == SortType.GROUP_TYPE) {
                result?.let { tasks.value = it }
            }
        }
    }

    fun sortTasks(sortType: SortType) = when(sortType) {
        SortType.DUE_DATE -> tasksSortedByDate.value?.let { tasks.value = it }
        SortType.GROUP_TYPE -> tasksSortedByGroup.value?.let { tasks.value = it }
    }.also {
        this.sortType = sortType
    }

    fun insertTask(taskEntity: TaskEntity) = viewModelScope.launch {
        taskRepository.insertTask(taskEntity)
    }

}