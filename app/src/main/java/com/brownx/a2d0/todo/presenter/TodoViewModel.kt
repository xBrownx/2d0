package com.brownx.a2d0.todo.presenter

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
 * created on 26/05/2024
 */
@HiltViewModel
class TodoViewModel @Inject constructor (
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _todoState = MutableStateFlow(TodoState())
    val todoState = _todoState.asStateFlow()

    init {
        getTaskListFromLocal()
    }

    fun onEvent(uiEvent: TodoUiEvents) {
        when(uiEvent) {
            is TodoUiEvents.OnSelectTask -> {}
        }
    }

    private fun getTaskListFromLocal() {
        viewModelScope.launch {
            mainRepository.getUserTasksFromLocal().collectLatest { result ->
                when(result) {
                    is Resource.Success -> {
                        _todoState.update {
                            it.copy(todoList = result.data)
                        }
                    }
                    is Resource.Error -> Timber.d("Resource.Error == ${result.error}")
                    is Resource.Loading -> Timber.d("Resource.Loading == ${result.isLoading}")
                    Resource.Idle -> Timber.d("Resource.Idle == ${result.message}")

                }
            }
        }
    }

}