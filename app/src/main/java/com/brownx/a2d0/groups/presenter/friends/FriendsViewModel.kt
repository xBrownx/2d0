package com.brownx.a2d0.groups.presenter.friends

import androidx.compose.runtime.collectAsState
import androidx.compose.runtime.mutableStateOf
import androidx.lifecycle.ViewModel
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 10/06/2024
 */
@HiltViewModel
class FriendsViewModel @Inject constructor(

) : ViewModel() {

    private val _friendsState = MutableStateFlow(FriendsState())
    val friendsState = _friendsState.asStateFlow()

    fun onEvent(uiEvent: FriendsUiEvents) {
        when(uiEvent) {
            is FriendsUiEvents.Hello -> {}
            else -> {}
        }
    }

}