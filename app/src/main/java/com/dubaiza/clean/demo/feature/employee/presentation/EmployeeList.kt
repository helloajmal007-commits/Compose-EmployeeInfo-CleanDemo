package com.dubaiza.clean.demo.feature.employee.presentation

import androidx.compose.foundation.layout.Arrangement
import androidx.compose.foundation.layout.PaddingValues
import androidx.compose.foundation.layout.fillMaxSize
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.runtime.Composable
import androidx.compose.ui.Modifier
import androidx.compose.ui.unit.dp
import com.dubaiza.clean.demo.domain.model.Employee
import com.dubaiza.clean.demo.feature.employee.component.EmployeeItem

@Composable
//fun EmployeeList(employees: List<Employee>) {
fun EmployeeList(employees: List<Employee>, onDelete: (Employee) -> Unit) {
    LazyColumn(
        modifier = Modifier.Companion.fillMaxSize(),
        contentPadding = PaddingValues(16.dp),
        verticalArrangement = Arrangement.spacedBy(8.dp)
    ) {

        items(employees) { employee ->
//            EmployeeItem(employee)
            EmployeeItem(employee = employee, onDelete = { onDelete(employee) })
//            Divider()
        }
    }
}