package com.brownx.a2d0.todo.presenter.createTask

import android.os.Build
import androidx.annotation.RequiresApi
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.util.DateUtil
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

    @RequiresApi(Build.VERSION_CODES.O)
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
                    it.copy(taskDescription = uiEvent.taskDesc)
                }
            }
            is CreateTaskUiEvents.OnDueDateChanged -> {
                val dateToString = if(uiEvent.dueDateMillis > 0) {
                    val millisToLocalDate = DateUtil()
                        .convertMillisToLocalDate(uiEvent.dueDateMillis)
                    DateUtil().dateToString(millisToLocalDate)
                } else {
                    "ANYTIME"
                }

                _createTaskState.update {
                    it.copy(
                        dueDateString = dateToString,
                        dueDateInMillis = uiEvent.dueDateMillis
                    )
                }
            }
            is CreateTaskUiEvents.OnDueTimeChanged -> {
                val timeToString = if(uiEvent.hour >= 0) {
                    DateUtil().timeToString(
                        hour = uiEvent.hour,
                        minute = uiEvent.minute,
                    )
                } else {
                    "ANYTIME"
                }
                val timeToMillis = if(uiEvent.hour >= 0) {
                    DateUtil().timeToMillis(
                        hour = uiEvent.hour,
                        minute = uiEvent.minute,
                    )
                } else {
                    -1
                }
                _createTaskState.update {
                    it.copy(
                        dueTimeString = timeToString,
                        dueTimeInMillis = timeToMillis
                    )
                }
            }

            CreateTaskUiEvents.OnSaveTask -> {
                saveTaskToRemote()
            }
            else -> {}
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