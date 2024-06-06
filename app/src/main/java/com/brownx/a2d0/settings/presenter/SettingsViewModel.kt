package com.brownx.a2d0.settings.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.auth.domain.repository.AuthRepository
import com.brownx.a2d0.auth.util.AuthResult
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 5/06/2024
 */
@HiltViewModel
class SettingsViewModel @Inject constructor(
    private val authRepository: AuthRepository
) : ViewModel() {

    private val _logoutResultChannel = Channel<AuthResult<Unit>>()
    val logoutResultChannel = _logoutResultChannel.receiveAsFlow()

    fun onEvent(profileUiEvent: SettingsUiEvents) {
        when (profileUiEvent) {
            SettingsUiEvents.Logout -> {
                Timber.d("onEvent = SettingsUiEvents.Logout")
                viewModelScope.launch {
                    _logoutResultChannel.send(
                        authRepository.logout()
                    )
                }
            }
        }
    }
}