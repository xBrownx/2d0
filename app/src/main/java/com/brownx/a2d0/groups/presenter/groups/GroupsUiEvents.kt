package com.brownx.a2d0.groups.presenter.groups

/**
 * @author Andrew Brown
 * created on 29/05/2024
 */
sealed class GroupsUiEvents {

    data class OnSelectGroup(
        val group: String
    ) : GroupsUiEvents()


}