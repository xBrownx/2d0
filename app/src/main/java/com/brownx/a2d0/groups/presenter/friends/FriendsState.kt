package com.brownx.a2d0.groups.presenter.friends

import com.brownx.a2d0.main.domain.model.Friend

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
data class FriendsState(

    val isLoading: Boolean = false,
    val friendsList: List<Friend> = listOf(),
)
