package com.dubaiza.clean.demo.feature.employee.component

import androidx.compose.foundation.background
import androidx.compose.foundation.layout.Box
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Row
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.foundation.layout.size
import androidx.compose.foundation.layout.width
import androidx.compose.foundation.shape.CircleShape
import androidx.compose.foundation.shape.RoundedCornerShape
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.Delete
import androidx.compose.material3.Card
import androidx.compose.material3.CardDefaults
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.runtime.Composable
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import com.dubaiza.clean.demo.domain.model.Employee

@Composable
fun EmployeeItem(
    employee: Employee,
    onDelete: () -> Unit
) {
    Card(
        modifier = Modifier.Companion
            .fillMaxWidth()
            .padding(horizontal = 4.dp, vertical = 3.dp),
        shape = RoundedCornerShape(16.dp),
        elevation = CardDefaults.cardElevation(defaultElevation = 2.dp)
    ) {
        Row(
            modifier = Modifier.Companion
                .fillMaxWidth()
                .padding(16.dp),
            verticalAlignment = Alignment.Companion.CenterVertically
        ) {

            // Avatar Circle
            Box(
                modifier = Modifier.Companion
                    .size(50.dp)
                    .background(
                        color = MaterialTheme.colorScheme.primary.copy(alpha = 0.2f),
                        shape = CircleShape
                    ),
                contentAlignment = Alignment.Companion.Center
            ) {
                Text(
                    text = employee.name.firstOrNull()?.uppercase() ?: "E",
                    style = MaterialTheme.typography.titleMedium,
                    color = MaterialTheme.colorScheme.primary
                )
            }

            Spacer(modifier = Modifier.Companion.width(12.dp))

            // Employee Info
            Column(
                modifier = Modifier.Companion.weight(1f)
            ) {
                Text(
                    text = employee.name,
                    style = MaterialTheme.typography.titleMedium,
                    fontWeight = FontWeight.Companion.SemiBold
                )

                Spacer(modifier = Modifier.Companion.height(4.dp))

                Text(
                    text = employee.designation,
                    style = MaterialTheme.typography.bodyMedium,
                    color = MaterialTheme.colorScheme.primary
                )

                Text(
                    text = employee.department,
                    style = MaterialTheme.typography.bodySmall,
                    color = MaterialTheme.colorScheme.onSurfaceVariant
                )
            }

            // Delete Button
            IconButton(
                onClick = onDelete
            ) {
                Icon(
                    imageVector = Icons.Default.Delete,
                    contentDescription = "Delete Employee",
                    tint = MaterialTheme.colorScheme.error
                )
            }
        }
    }
}