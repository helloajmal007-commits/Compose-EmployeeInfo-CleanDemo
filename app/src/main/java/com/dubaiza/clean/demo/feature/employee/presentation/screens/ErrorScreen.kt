package com.dubaiza.clean.demo.feature.employee.presentation.screens

import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier

@Composable
fun ErrorScreen(message: String) {
    Box(
        modifier = Modifier.Companion.fillMaxSize(),
        contentAlignment = Alignment.Companion.Center
    ) {
        Text(text = "Error: $message")
    }
}