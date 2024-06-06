package com.brownx.a2d0.groups.presenter.createGroup

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.main.data.local.entity.GroupEntity
import com.brownx.a2d0.main.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */

@HiltViewModel
class CreateGroupViewModel @Inject constructor(
    private val mainRepository: MainRepository
) : ViewModel() {

    private val _createGroupState = MutableStateFlow(CreateGroupState())
    val createGroupState = _createGroupState.asStateFlow()

    fun onEvent(uiEvent: CreateGroupUiEvent) {
        when(uiEvent) {
            is CreateGroupUiEvent.OnEditGroupName -> {
                _createGroupState.update {
                    it.copy(
                        groupName = it.groupName
                    )
                }
            }
            is CreateGroupUiEvent.OnCreateGroup -> {
                //insertGroup(Group())
            }
        }
    }

//    private fun insertGroup(groupEntity: GroupEntity) = viewModelScope.launch {
//        mainRepository.insertGroup(groupEntity)
//    }
}