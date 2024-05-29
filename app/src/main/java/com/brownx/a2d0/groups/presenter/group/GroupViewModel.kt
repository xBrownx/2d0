package com.brownx.a2d0.groups.presenter.group

import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.core.data.local.group.Group
import com.brownx.a2d0.core.domain.repository.GroupRepository
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
class GroupViewModel @Inject constructor(
    private val groupRepository: GroupRepository
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

    private fun deleteGroup(group: Group) = viewModelScope.launch {
        groupRepository.deleteGroup(group)
    }



}