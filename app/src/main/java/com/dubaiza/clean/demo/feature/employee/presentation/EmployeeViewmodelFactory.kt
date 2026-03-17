package com.dubaiza.clean.demo.feature.employee.presentation

import androidx.lifecycle.ViewModel
import androidx.lifecycle.ViewModelProvider
import com.dubaiza.clean.demo.domain.usecase.DeleteEmployeeUsecase
import com.dubaiza.clean.demo.domain.usecase.GetAllEmployeeUseCase
import com.dubaiza.clean.demo.domain.usecase.InsertEmployeeUsecase
import com.dubaiza.clean.demo.domain.usecase.InsertEmployeesUsecase

class EmployeeViewModelFactory(
    private val getAllEmployeeUseCase: GetAllEmployeeUseCase,
    private val insertEmployeeUsecase: InsertEmployeeUsecase,
    private val insertEmployeesUsecase: InsertEmployeesUsecase,
    private val deleteEmployeeUsecase: DeleteEmployeeUsecase,
   /* private val addEmployeeUsecase: AddEmployeeUsecase,
    private val addEmployeesUsecase: AddEmployeesUsecase,
    private val updateEmployeeUsecase: UpdateEmployeeUsecase,

    private val deleteAllEmployeesUsecase: DeleteAllEmployeesUsecase,
    private val getEmployeeByIdUsecase: GetEmployeeByIdUsecase*/
) : ViewModelProvider.Factory {

    @Suppress("UNCHECKED_CAST")
    override fun <T : ViewModel> create(modelClass: Class<T>): T {
        if (modelClass.isAssignableFrom(EmployeeViewModel::class.java)) {
            return EmployeeViewModel(
                getAllEmployeeUseCase,
                insertEmployeeUsecase,
                insertEmployeesUsecase,
                deleteEmployeeUsecase
            /*,
                addEmployeeUsecase,
                addEmployeesUsecase,
                updateEmployeeUsecase,

                deleteAllEmployeesUsecase,
                getEmployeeByIdUsecase,*/
            ) as T
        }
        throw IllegalArgumentException("Unknown ViewModel class: ${modelClass.name}")
    }
}