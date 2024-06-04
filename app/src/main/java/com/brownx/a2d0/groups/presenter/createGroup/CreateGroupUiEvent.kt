package com.brownx.a2d0.groups.presenter.createGroup

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
sealed class CreateGroupUiEvent {

    data class OnEditGroupName (
        val groupName: String
    ) : CreateGroupUiEvent()

    data object OnCreateGroup : CreateGroupUiEvent()

}