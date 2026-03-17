package com.dubaiza.clean.demo.feature.employee.presentation.screens

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.Spacer
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.foundation.layout.height
import androidx.compose.foundation.layout.padding
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.ArrowBack
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.OutlinedTextField
import androidx.compose.material3.Scaffold
import androidx.compose.material3.Text
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dubaiza.clean.demo.domain.model.Employee


@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun AddEmployeeScreen(
    onSave: (Employee) -> Unit,
    onBack: () -> Unit
) {
    var name by remember { mutableStateOf("") }
    var designation by remember { mutableStateOf("") }
    var department by remember { mutableStateOf("") }

    Scaffold(
        topBar = {
            TopAppBar(
                title = { Text("Add Employee") },
                navigationIcon = {
                    IconButton(onClick = onBack) {
                        Icon(Icons.Default.ArrowBack, null)
                    }
                }
            )
        }
    ) { padding ->

        Column(
            modifier = Modifier
                .padding(padding)
                .padding(16.dp),
            verticalArrangement = Arrangement.spacedBy(12.dp)
        ) {

            OutlinedTextField(
                value = name,
                onValueChange = { name = it },
                label = { Text("Full Name") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = designation,
                onValueChange = { designation = it },
                label = { Text("Designation") },
                modifier = Modifier.fillMaxWidth()
            )

            OutlinedTextField(
                value = department,
                onValueChange = { department = it },
                label = { Text("Department") },
                modifier = Modifier.fillMaxWidth()
            )

            Spacer(modifier = Modifier.height(20.dp))

            Button(
                onClick = {
                    onSave(
                        Employee(
                            name = name,
                            designation = designation,
                            department = department
                        )
                    )
                },
                modifier = Modifier.fillMaxWidth()
            ) {
                Text("Save Employee")
            }
        }
    }
}