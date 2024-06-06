package com.brownx.a2d0.main.presenter

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.brownx.a2d0.main.domain.repository.MainRepository
import com.brownx.a2d0.util.Resource
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.asStateFlow
import kotlinx.coroutines.flow.update
import kotlinx.coroutines.launch
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

    init {
        refresh()
    }

    fun onEvent(uiEvent: MainUiEvents) {

    }

    fun refresh() {
        viewModelScope.launch {
            mainRepository.getUserGroupsFromRemote().collect { result ->
                when (result) {
                    is Resource.Success -> {
                        result.data.let { groupList ->

                        }
                    }
                    is Resource.Loading -> {
                        _mainState.update {
                            it.copy(isLoading = result.isLoading)
                        }
                    }

                    else -> {}
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