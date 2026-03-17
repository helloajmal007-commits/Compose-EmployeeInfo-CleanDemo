package com.dubaiza.clean.demo.feature.splash.presentation

sealed class SplashUiState {
    object Loading : SplashUiState()
    object NavigateToHome : SplashUiState()
}