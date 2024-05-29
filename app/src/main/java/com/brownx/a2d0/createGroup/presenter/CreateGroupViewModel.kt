package com.brownx.a2d0.createGroup.presenter

import androidx.lifecycle.ViewModel
import com.brownx.a2d0.core.domain.repository.GroupRepository
import com.brownx.a2d0.core.domain.repository.TaskRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@HiltViewModel
class CreateGroupViewModel @Inject constructor(
    private val groupRepository: GroupRepository
) : ViewModel() {

    private val _createGroupState = MutableStateFlow(CreateGroupState())
    val createGroupState = _createGroupState.asStateFlow()

    fun onUiEvent(uiEvent: CreateGroupUiEvent) {
        when(uiEvent) {
            is CreateGroupUiEvent.OnEditGroupName -> {
                _createGroupState.update {
                    it.copy(
                        groupName = it.groupName
                    )
                }
            }

            is CreateGroupUiEvent.OnCreateGroup -> {
                insertGroupIntoLocalDb()
            }
            else -> {}
        }
    }

    private fun insertGroupIntoLocalDb() {

    }
}