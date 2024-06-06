package com.brownx.a2d0.groups.presenter.groups

import androidx.compose.runtime.collectAsState
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.groups.domain.repository.GroupRepository
import com.brownx.a2d0.groups.util.GroupSortType
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.ExperimentalCoroutinesApi
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.SharingStarted
import kotlinx.coroutines.flow.WhileSubscribed
import kotlinx.coroutines.flow.asFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.combine
import kotlinx.coroutines.flow.flatMapLatest
import kotlinx.coroutines.flow.stateIn
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@HiltViewModel
class GroupsViewModel @Inject constructor(
    private val groupRepository: GroupRepository,
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _groupsState = MutableStateFlow(GroupsState())
    val groupsState = _groupsState.asStateFlow()

    init {
        getGroupList()
    }

    fun onEvent(uiEvent: GroupsUiEvents) {
        when(uiEvent) {
            is GroupsUiEvents.OnRefreshGroups -> {
                refreshGroupsFromRemote()
            }
            is GroupsUiEvents.OnSelectGroup -> {

            }
            is GroupsUiEvents.OnAddGroup -> {

            }
        }
    }

    private fun getGroupList() {
        viewModelScope.launch {
            groupRepository.getAllGroups().collectLatest { result ->
                when(result) {
                    is Resource.Success -> {
                        Timber.d("Resource.Success == ${result.message}")
                        _groupsState.update {
                            it.copy(
                                groupsList = result.data
                            )
                        }
                    }
                    is Resource.Error -> {
                        Timber.d("Resource.Error == ${result.error}")
                    }
                    Resource.Idle -> {
                        Timber.d("Resource.Idle == ${result.message}")
                    }
                    is Resource.Loading -> {
                        Timber.d("Resource.Loading == ${result.isLoading}")
                    }
                }
            }
        }
    }

    private fun refreshGroupsFromRemote() {

    }


}