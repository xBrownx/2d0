package com.brownx.a2d0.main.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.groups.domain.repository.GroupRepository
import com.brownx.a2d0.tasks.data.repository.TaskRepository
import com.brownx.a2d0.friends.domain.repository.FriendsRepository
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
    private val groupRepository: GroupRepository,
    private val taskRepository: TaskRepository,
    private val friendsRepository: FriendsRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    init {
        loadAll()
    }

    fun onEvent(uiEvent: MainUiEvents) {

    }

    private fun loadAll() {
        viewModelScope.launch {
            mainRepository.getGroupsByUser().collect { result ->
                when (result) {
                    is Resource.Error -> Unit

                    is Resource.Loading -> {
                        _mainState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    is Resource.Success -> {
                        result.data.let { groupList ->


                        }
                    }

                    else -> {}
                }
            }
        }
    }
}