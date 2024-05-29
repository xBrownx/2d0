package com.brownx.a2d0.groups.presenter.group

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
sealed class GroupUiEvents {

    data object OnAddGroupMember : GroupUiEvents()

    data object OnDeleteGroupMember : GroupUiEvents()

    data object OnDeleteGroup : GroupUiEvents()
}