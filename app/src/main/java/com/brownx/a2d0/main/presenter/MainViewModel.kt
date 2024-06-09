package com.brownx.a2d0.main.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.collectLatest
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
import timber.log.Timber
import javax.inject.Inject

/**
 * @author Andrew Brown
 * created on 2/06/2024
 */
@HiltViewModel
class MainViewModel @Inject constructor(
    private val mainRepository: MainRepository,
) : ViewModel() {

    private val _mainState = MutableStateFlow(MainState())
    val mainState = _mainState.asStateFlow()

    fun onEvent(uiEvent: MainUiEvents) {
        when(uiEvent) {
            MainUiEvents.LoadAllRemoteData -> refresh()
        }
    }

    private fun refresh() {
        Timber.d("REFRESHING FROM MAIN VIEW MODEL")
        viewModelScope.launch {
            mainRepository.getUserDataFromRemote().collectLatest { result ->
                when (result) {
                    is Resource.Success -> {
                        Timber.d("MISSION SUCCESS")
                    }
                    is Resource.Loading -> {
                        _mainState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    else -> {
                        Timber.d("MISSION SUCCESS")
                    }
                }
                _mainState.update {
                    it.copy(
                        isLoading = false,
                        isRefreshing = false
                    )
                }
            }
        }
    }

    private fun loadAll() {

    }
}