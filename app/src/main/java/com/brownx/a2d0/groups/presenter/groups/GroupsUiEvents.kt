package com.brownx.a2d0.groups.presenter.groups

import com.brownx.a2d0.groups.domain.model.Group

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
sealed class GroupsUiEvents {

    data class OnSelectGroup(
        val group: Group
    ) : GroupsUiEvents()

    data object OnRefreshGroups : GroupsUiEvents()
    data object OnAddGroup : GroupsUiEvents()

}