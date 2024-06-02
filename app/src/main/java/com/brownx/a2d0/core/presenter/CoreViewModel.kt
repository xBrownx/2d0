package com.brownx.a2d0.core.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.auth.domain.repository.AuthRepository
import com.brownx.a2d0.auth.util.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
@HiltViewModel
class CoreViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _authResultChannel = Channel<AuthResult<Unit>>()
    val authResultChannel = _authResultChannel.receiveAsFlow()

    private val _coreState = MutableStateFlow(CoreState())
    val coreState = _coreState.asStateFlow()

    init {
        authenticate()
    }

    fun onEvent(uiEvent: CoreUiEvents) {
        when(uiEvent) {
            is CoreUiEvents.LoadAll -> {

            }
        }
    }

    private fun authenticate() {
        viewModelScope.launch {
            _coreState.update {
                it.copy(isLoading = true)
            }
            val result = authRepository.authenticate()
            _authResultChannel.send(result)
            _coreState.update {
                it.copy(isLoading = false)
            }
        }
    }
}