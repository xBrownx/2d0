package com.brownx.a2d0.groups.presenter.groups

import androidx.lifecycle.ViewModel
import com.brownx.a2d0.main.domain.repository.GroupRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
@HiltViewModel
class GroupsViewModel @Inject constructor(
    private val groupRepository: GroupRepository
) : ViewModel() {

    private val _groupsState = MutableStateFlow(GroupsState())
    val groupsState = _groupsState.asStateFlow()

    fun onEvent(uiEvent: GroupsUiEvents) {

    }


}