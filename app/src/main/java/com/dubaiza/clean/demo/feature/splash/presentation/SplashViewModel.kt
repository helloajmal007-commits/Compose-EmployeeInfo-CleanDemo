package com.dubaiza.clean.demo.feature.splash.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import kotlinx.coroutines.delay
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.launch

class SplashViewModel : ViewModel() {

    private val _uiState = MutableStateFlow<SplashUiState>(SplashUiState.Loading)
    val uiState: StateFlow<SplashUiState> = _uiState

    init {
        startSplash()
    }

    private fun startSplash() {
        viewModelScope.launch {
            delay(3000) // business logic here ✅
            _uiState.value = SplashUiState.NavigateToHome
        }
    }
}