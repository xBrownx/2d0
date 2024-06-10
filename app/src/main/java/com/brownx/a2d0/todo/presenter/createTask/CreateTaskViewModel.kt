package com.brownx.a2d0.todo.presenter.createTask

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
@HiltViewModel
class CreateTaskViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _createTaskState = MutableStateFlow(CreateTaskState())
    val createTaskState = _createTaskState.asStateFlow()

    init {
        getGroupListFromLocal()
    }

    fun onEvent(uiEvent: CreateTaskUiEvents) {
        when(uiEvent) {
            is CreateTaskUiEvents.OnGroupNameChanged -> {
                _createTaskState.update {
                    it.copy(groupName = uiEvent.groupName)
                }
            }
            is CreateTaskUiEvents.OnTaskNameChanged -> {
                _createTaskState.update {
                    it.copy(taskName = uiEvent.taskName)
                }
            }
            is CreateTaskUiEvents.OnTaskDescChanged -> {
                _createTaskState.update {
                    it.copy(taskDesc = uiEvent.taskDesc)
                }
            }
            is CreateTaskUiEvents.OnDueDateChanged -> {
                _createTaskState.update {
                    it.copy(dueDate = uiEvent.dueDate)
                }
            }
            CreateTaskUiEvents.OnSaveTask -> {
                saveTaskToRemote()
            }


        }
    }

    private fun getGroupListFromLocal() {

        viewModelScope.launch {
            mainRepository.getUserGroupsFromLocal().collectLatest { result ->
                when(result) {
                    is Resource.Success -> {
                        _createTaskState.update {
                            it.copy(
                                groupsList = result.data,
                                groupName = result.data[0].groupName.uppercase()
                            )
                        }
                    }
                    is Resource.Error -> Timber.d("Resource.Error == ${result.error}")
                    is Resource.Loading -> Timber.d("Resource.Loading == ${result.isLoading}")
                    Resource.Idle -> Timber.d("Resource.Idle == ${result.message}")
                }
            }
        }
    }

    private fun saveTaskToRemote() {

    }
}