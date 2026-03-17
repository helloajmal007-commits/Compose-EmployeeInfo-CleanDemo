package com.dubaiza.clean.demo.feature.employee.presentation

import com.dubaiza.clean.demo.domain.model.Employee


sealed interface EmployeeUiState {
   data object Loading : EmployeeUiState                // While fetching data
    data class Success(val employees: List<Employee>,
        val isLoading: Boolean = false) : EmployeeUiState  // Data loaded
    data class Error(val message: String) : EmployeeUiState              // Error state
    object Empty : EmployeeUiState                  // No employees available
}