package com.dubaiza.clean.demo.feature.splash.presentation

import androidx.compose.animation.core.Animatable
import androidx.compose.animation.core.FastOutSlowInEasing
import androidx.compose.animation.core.tween
import androidx.compose.foundation.background
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.draw.scale
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.lifecycle.viewmodel.compose.viewModel

@Composable
fun SplashScreen(
    viewModel: SplashViewModel = viewModel(),
    onNavigate: () -> Unit
) {
    val uiState by viewModel.uiState.collectAsState()

    val scale = remember { Animatable(0.6f) }

    // Animation only (UI responsibility ✅)
    LaunchedEffect(Unit) {
        // Animation
        scale.animateTo(
            targetValue = 1f,
            animationSpec = tween(
                durationMillis = 800,
                easing = FastOutSlowInEasing
            )
        )
    }

    // Navigation trigger from state ✅
    LaunchedEffect(uiState) {
        if (uiState is SplashUiState.NavigateToHome) {
            onNavigate()
        }
    }

    // UI
    Box(
        modifier = Modifier
            .fillMaxSize()
            .background(MaterialTheme.colorScheme.primary),
        contentAlignment = Alignment.Center
    ) {
        Column(horizontalAlignment = Alignment.CenterHorizontally) {

            // Logo / Initial
            Box(
                modifier = Modifier
                    .size(100.dp)
                    .scale(scale.value)
                    .background(Color.White, shape = CircleShape),
                contentAlignment = Alignment.Center
            ) {
                Text(
                    text = "E",
                    style = MaterialTheme.typography.headlineLarge,
                    color = MaterialTheme.colorScheme.primary,
                    fontWeight = FontWeight.Bold
                )
            }

            Spacer(modifier = Modifier.height(16.dp))

            Text(
                text = "Employee Manager",
                style = MaterialTheme.typography.titleLarge,
                color = Color.White,
                fontWeight = FontWeight.SemiBold
            )

            Spacer(modifier = Modifier.height(8.dp))

            Text(
                text = "Manage your team efficiently",
                style = MaterialTheme.typography.bodyMedium,
                color = Color.White.copy(alpha = 0.8f)
            )
        }
    }
}
