package com.brownx.a2d0.groups.presenter.groups

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
 * created on 29/05/2024
 */

@HiltViewModel
class GroupsViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _groupsState = MutableStateFlow(GroupsState())
    val groupsState = _groupsState.asStateFlow()

    init {
        getGroupListFromLocal()
    }

    fun onEvent(uiEvent: GroupsUiEvents) {
        when(uiEvent) {
            is GroupsUiEvents.OnRefreshGroups -> {}
            is GroupsUiEvents.OnSelectGroup -> {}
            is GroupsUiEvents.OnAddGroup -> {}
        }
    }

    private fun getGroupListFromLocal() {
        viewModelScope.launch {
            mainRepository.getUserGroupsFromLocal().collectLatest { result ->
                when(result) {
                    is Resource.Success -> {
                        _groupsState.update {
                            it.copy(groupsList = result.data)
                        }
                    }
                    is Resource.Error -> Timber.d("Resource.Error == ${result.error}")
                    is Resource.Loading -> Timber.d("Resource.Loading == ${result.isLoading}")
                    Resource.Idle -> Timber.d("Resource.Idle == ${result.message}")

                }
            }
        }
    }

    private fun getGroupListFromRemote() {

    }


}