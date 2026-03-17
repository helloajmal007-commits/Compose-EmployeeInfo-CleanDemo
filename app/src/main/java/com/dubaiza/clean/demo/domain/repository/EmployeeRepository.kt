package com.dubaiza.clean.demo.domain.repository

import com.dubaiza.clean.demo.domain.model.Employee
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.FlowCollector

interface EmployeeRepository {

    suspend fun insertEmployee(employee: Employee)
    suspend fun inserAlltEmployee(employees: List<Employee>)
    fun getAllEmployees(): Flow<List<Employee>>

    suspend fun addEmployee(employee: Employee)
    suspend fun addEmployees(employees: List<Employee>)
    suspend fun updateEmployee(employee: Employee)
    suspend fun deleteEmployee(employee: Employee)
    suspend fun deleteAllEmployees()

    suspend fun getEmployeeById(id: Int): Employee?
}