package com.dubaiza.clean.demo.domain.usecase

import com.dubaiza.clean.demo.domain.model.Employee
import com.dubaiza.clean.demo.domain.repository.EmployeeRepository

class InsertEmployeeUsecase(private val repository: EmployeeRepository) {

    suspend operator fun invoke(employee: Employee){

//        var employee = Employee(   "Jhon", "Driver", "Development")

        repository.insertEmployee(employee)
    }
}

