package com.dubaiza.clean.demo.feature.employee.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.viewModelScope
import com.dubaiza.clean.demo.domain.model.Employee
import com.dubaiza.clean.demo.domain.usecase.DeleteEmployeeUsecase
import com.dubaiza.clean.demo.domain.usecase.GetAllEmployeeUseCase
import com.dubaiza.clean.demo.domain.usecase.InsertEmployeeUsecase
import com.dubaiza.clean.demo.domain.usecase.InsertEmployeesUsecase
import kotlinx.coroutines.flow.MutableStateFlow
import kotlinx.coroutines.flow.StateFlow
import kotlinx.coroutines.flow.catch
import kotlinx.coroutines.launch

class EmployeeViewModel /*@Inject */constructor(
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase,
    private val insertEmployeeUsecase: InsertEmployeeUsecase,
    private val insertEmployeesUsecase: InsertEmployeesUsecase,
    private val deleteEmployeeUsecase: DeleteEmployeeUsecase,
    /*private val addEmployeeUsecase: AddEmployeeUsecase,
    private val addEmployeesUsecase: AddEmployeesUsecase,
    private val updateEmployeeUsecase: UpdateEmployeeUsecase,

    private val deleteAllEmployeesUsecase: DeleteAllEmployeesUsecase,
    private val getEmployeeByIdUsecase: GetEmployeeByIdUsecase*/
    ) :
    ViewModel() {

    private val _uiState = MutableStateFlow<EmployeeUiState>(EmployeeUiState.Loading)
    val uiState: StateFlow<EmployeeUiState> = _uiState

    init {
        fetchEmployees()
    }

    /** Fetch all employees from repository */
    fun fetchEmployees() {
        viewModelScope.launch {

            getAllEmployeeUseCase.invoke()
                .catch { e ->
                    _uiState.value = EmployeeUiState.Error(e.message ?: "Something went wrong")
                }
                .collect { employees ->
                    _uiState.value = when {
                        employees.isEmpty() -> EmployeeUiState.Empty
                        else -> EmployeeUiState.Success(employees)
                    }
                }
        }
    }

    /** Add a new employee */
    fun addEmployee(employee: Employee) {
        viewModelScope.launch {
            try {
                insertEmployeeUsecase.invoke(employee)
                fetchEmployees() // refresh after add
            } catch (e: Exception) {
                _uiState.value = EmployeeUiState.Error(e.message ?: "Failed to add employee")
            }
        }
    }

    /** Add a new employee */
    fun insertSampleEmployees() {
        viewModelScope.launch {
            try {
                val currentState = _uiState.value
                if (currentState is EmployeeUiState.Success){
                    _uiState.value = currentState.copy(isLoading = true)
                }

                insertEmployeesUsecase.invoke()
//                fetchEmployees() // refresh after add
            } catch (e: Exception) {
                _uiState.value = EmployeeUiState.Error(e.message ?: "Failed to add employee")
            }
        }
    }

//    /** Add multiple employees (alternative use case) */
//    fun addEmployees(employees: List<Employee>) {
//        viewModelScope.launch {
//            try {
//                addEmployeesUsecase(employees)
//                fetchEmployees()
//            } catch (e: Exception) {
//                _uiState.value = EmployeeUiState.Error(e.message ?: "Failed to add employee")
//            }
//        }
//    }
//
//    /** Update an existing employee */
//    fun updateEmployee(employee: Employee) {
//        viewModelScope.launch {
//            try {
//                updateEmployeeUsecase(employee)
//                fetchEmployees()
//            } catch (e: Exception) {
//                _uiState.value = EmployeeUiState.Error(e.message ?: "Failed to update employee")
//            }
//        }
//    }
//
//    /** Delete a single employee */
    fun deleteEmployee(employee: Employee) {
        viewModelScope.launch {
            try {
                deleteEmployeeUsecase(employee)
                fetchEmployees()
            } catch (e: Exception) {
                _uiState.value = EmployeeUiState.Error(e.message ?: "Failed to delete employee")
            }
        }
    }
//
//    /** Delete all employees */
//    fun deleteAllEmployees() {
//        viewModelScope.launch {
//            try {
//                deleteAllEmployeesUsecase()
//                fetchEmployees()
//            } catch (e: Exception) {
//                _uiState.value = EmployeeUiState.Error(e.message ?: "Failed to delete all employees")
//            }
//        }
//    }
}