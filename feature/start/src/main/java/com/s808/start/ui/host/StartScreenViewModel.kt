package com.s808.start.ui.host

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.s808.data.civilian.repo.start.StartScreenRepository
import dagger.hilt.android.lifecycle.HiltViewModel
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch
import kotlinx.coroutines.runBlocking
import javax.inject.Inject

@HiltViewModel
class StartScreenViewModel @Inject constructor(
    private val startScreenRepository: StartScreenRepository
) : ViewModel() {

    private val initTab = runBlocking { startScreenRepository.getCurrentTab() }
    private val _uiState = MutableStateFlow(value = StartScreenViewState(initTab))
    val uiState: StateFlow<StartScreenViewState> = _uiState

    fun onTabChange(tabIndex: Int) {
        viewModelScope.launch {
            startScreenRepository.setCurrentTab(tabIndex)
            _uiState.value = StartScreenViewState(tabIndex)
        }
    }
}
