package com.brownx.a2d0.groups.presenter.group

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.main.data.local.entity.GroupEntity
import com.brownx.a2d0.main.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
@HiltViewModel
class GroupViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _groupState = MutableStateFlow(GroupState())
    val groupState = _groupState.asStateFlow()

    fun onEvent(uiEvent: GroupUiEvents) {
        when(uiEvent) {
            is GroupUiEvents.OnAddGroupMember -> { }
            is GroupUiEvents.OnDeleteGroup -> { }
            is GroupUiEvents.OnDeleteGroupMember -> { }
        }
    }

    private fun editGroupMembers() {

    }

    private fun deleteGroup(groupEntity: GroupEntity) = viewModelScope.launch {

    }



}