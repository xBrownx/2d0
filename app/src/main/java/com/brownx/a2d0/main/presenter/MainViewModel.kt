package com.brownx.a2d0.main.presenter

import androidx.lifecycle.ViewModel
import com.brownx.a2d0.groups.domain.repository.GroupRepository
import com.brownx.a2d0.tasks.data.repository.TaskRepository
import com.brownx.a2d0.friends.domain.repository.FriendsRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val groupRepository: GroupRepository,
    private val taskRepository: TaskRepository,
    private val friendsRepository: FriendsRepository
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    fun onEvent(uiEvent: MainUiEvents) {

    }

    fun loadAll() {

    }
}