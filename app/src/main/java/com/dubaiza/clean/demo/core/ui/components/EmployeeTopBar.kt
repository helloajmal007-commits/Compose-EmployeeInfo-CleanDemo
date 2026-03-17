package com.dubaiza.clean.demo.core.ui.components

import androidx.compose.foundation.layout.Column
import androidx.compose.foundation.layout.fillMaxWidth
import androidx.compose.material.icons.Icons
import androidx.compose.material.icons.filled.AccountCircle
import androidx.compose.material.icons.filled.Close
import androidx.compose.material.icons.filled.MoreVert
import androidx.compose.material.icons.filled.Refresh
import androidx.compose.material.icons.filled.Search
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Icon
import androidx.compose.material3.IconButton
import androidx.compose.material3.MaterialTheme
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.material3.TopAppBar
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.text.font.FontWeight

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeTopBar(
    searchQuery: String,
    onSearchChange: (String) -> Unit,
    isSearching: Boolean,
    onToggleSearch: () -> Unit,
    onRefresh: () -> Unit
) {
    TopAppBar(
        title = {
            if (isSearching) {
                TextField(
                    value = searchQuery,
                    onValueChange = onSearchChange,
                    placeholder = { Text("Search employees...") },
                    singleLine = true,
                    modifier = Modifier.Companion.fillMaxWidth(),
                    colors = TextFieldDefaults.textFieldColors()
                )
            } else {
                Column {
                    Text(
                        "Employees",
                        style = MaterialTheme.typography.titleLarge,
                        fontWeight = FontWeight.Companion.Bold
                    )
                    Text(
                        "Manage your team",
                        style = MaterialTheme.typography.labelSmall,
                        color = MaterialTheme.colorScheme.onSurfaceVariant
                    )
                }
            }
        },
        navigationIcon = {
            IconButton(onClick = { /* profile/menu */ }) {
                Icon(Icons.Default.AccountCircle, contentDescription = null)
            }
        },
        actions = {
            IconButton(onClick = onToggleSearch) {
                Icon(
                    if (isSearching) Icons.Default.Close else Icons.Default.Search,
                    contentDescription = "Search"
                )
            }

            IconButton(onClick = onRefresh) {
                Icon(Icons.Default.Refresh, contentDescription = "Refresh")
            }

            IconButton(onClick = { /* menu */ }) {
                Icon(Icons.Default.MoreVert, contentDescription = "More")
            }
        }
    )
}