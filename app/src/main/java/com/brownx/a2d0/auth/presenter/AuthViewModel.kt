package com.brownx.a2d0.auth.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.auth.domain.repository.AuthRepository
import com.brownx.a2d0.auth.domain.usecase.CreatePersonalGroupUseCase
import com.brownx.a2d0.auth.domain.usecase.FormValidatorUseCase
import com.brownx.a2d0.auth.util.AuthResult
import com.brownx.a2d0.groups.data.mapper.toGroupEntity
import com.brownx.a2d0.groups.domain.repository.GroupRepository
import com.brownx.a2d0.main.domain.repository.MainRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.channels.Channel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.receiveAsFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */

@HiltViewModel
class AuthViewModel @Inject constructor(
    private val authRepository: AuthRepository,
    private val groupRepository: GroupRepository,
    private val mainRepository: MainRepository,
    private val formValidatorUseCase: FormValidatorUseCase,
    private val createPersonalGroupUseCase: CreatePersonalGroupUseCase
) : ViewModel() {

    private val _authState = MutableStateFlow(AuthState())
    val authState = _authState.asStateFlow()

    private val _authResultChannel = Channel<AuthResult<Unit>>()
    val authResultChannel = _authResultChannel.receiveAsFlow()

    private val _invalidCredentialsChannel = Channel<Boolean>()
    val invalidCredentialsChannel = _invalidCredentialsChannel.receiveAsFlow()

    fun onEvent(uiEvent: AuthUiEvents) {
        when (uiEvent) {

            is AuthUiEvents.OnUsernameChanged -> {
                _authState.update {
                    it.copy(username = uiEvent.username)
                }
            }

            is AuthUiEvents.OnMobileChanged -> {
                _authState.update {
                    it.copy(mobile = uiEvent.mobile)
                }
            }

            is AuthUiEvents.OnPasswordChanged -> {
                _authState.update {
                    it.copy(password = uiEvent.password)
                }
            }

            is AuthUiEvents.OnConfirmPasswordChanged -> {
                _authState.update {
                    it.copy(confirmPassword = uiEvent.password)
                }
            }

            AuthUiEvents.Register -> {
                val isUsernameValid = true
                formValidatorUseCase.validateUsernameUseCase.invoke(
                    authState.value.username
                )
                val isMobileValid = true
                formValidatorUseCase.validateMobileUseCase.invoke(
                    authState.value.username
                )
                val isPasswordValid = true

                if (isUsernameValid && isMobileValid && isPasswordValid) {
                    register()
                } else {
                    Timber.d("Error validating form")
                    viewModelScope.launch {
                        _invalidCredentialsChannel.send(true)
                    }
                }
            }

            AuthUiEvents.Login -> {
                val isUsernameValid =
                    formValidatorUseCase.validateUsernameUseCase.invoke(
                        authState.value.username
                    )
                val isPasswordValid = true
//                    formValidatorUseCase.validatePasswordUseCase.invoke(
//                        authState.value.password
//                    )

                if (isUsernameValid && isPasswordValid) {
                    login()
                } else {
                    Timber.d("Error validating form")
                    viewModelScope.launch {
                        _invalidCredentialsChannel.send(true)
                    }
                }
            }


        }
    }

    private fun register() {
        Timber.d("register")
        viewModelScope.launch {
            _authState.update {
                it.copy(isLoading = true)
            }

            val result = authRepository.register(
                authState.value.username,
                authState.value.mobile,
                authState.value.password
            )

            when (result) {
                is AuthResult.Authorized -> {
                    Timber.d("result is authorised")
                    mainRepository.registerGroup(createPersonalGroupUseCase())
                }

                else -> {
                    Timber.d("result is not authorised")
                }
//                groupRepository.insertGroup(
//                    createPersonalGroupUseCase().toGroupEntity()
//                )
            }

            _authResultChannel.send(result)

            _authState.update {
                it.copy(isLoading = false)
            }
        }
    }

    private fun login() {
        Timber.d("Logging in")
        viewModelScope.launch {
            _authState.update {
                it.copy(isLoading = true)
            }

            val result = authRepository.login(
                authState.value.username,
                authState.value.password
            )

            _authResultChannel.send(result)

            _authState.update {
                it.copy(isLoading = false)
            }
        }
    }


}