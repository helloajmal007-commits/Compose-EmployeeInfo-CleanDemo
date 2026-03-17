package com.dubaiza.clean.demo.domain.usecase

import com.dubaiza.clean.demo.domain.model.Employee
import com.dubaiza.clean.demo.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow

/*class GetAllEmployeeUseCase(private val repository: EmployeeRepository) {

    operator fun invoke(): Flow<List<Employee>>{
        return repository.getAllEmployees()
    }
}*/


// Fetch all employees
class GetAllEmployeeUseCase(private val repository: EmployeeRepository) {
    operator fun invoke(): Flow<List<Employee>> = repository.getAllEmployees()
}

// Insert multiple employees
/*class InsertEmployeesUsecase(private val repository: EmployeeRepository) {
    suspend operator fun invoke(employees: List<Employee>) = repository.inserAlltEmployee(employees)
}*/

// Add single employee (alternative logic if needed)
class AddEmployeeUsecase(private val repository: EmployeeRepository) {
    suspend operator fun invoke(employee: Employee) = repository.addEmployee(employee)
}

// Add multiple employees
class AddEmployeesUsecase(private val repository: EmployeeRepository) {
    suspend operator fun invoke(employees: List<Employee>) = repository.addEmployees(employees)
}

// Update employee
class UpdateEmployeeUsecase(private val repository: EmployeeRepository) {
    suspend operator fun invoke(employee: Employee) = repository.updateEmployee(employee)
}

// Delete single employee
class DeleteEmployeeUsecase(private val repository: EmployeeRepository) {
    suspend operator fun invoke(employee: Employee) = repository.deleteEmployee(employee)
}

// Delete all employees
class DeleteAllEmployeesUsecase(private val repository: EmployeeRepository) {
    suspend operator fun invoke() = repository.deleteAllEmployees()
}

// Get employee by ID
class GetEmployeeByIdUsecase(private val repository: EmployeeRepository) {
    suspend operator fun invoke(id: Int): Employee? = repository.getEmployeeById(id)
}