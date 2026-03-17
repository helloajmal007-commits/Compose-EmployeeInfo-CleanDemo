package com.dubaiza.clean.demo.domain.usecase

import com.dubaiza.clean.demo.domain.model.Employee
import com.dubaiza.clean.demo.domain.repository.EmployeeRepository

class InsertEmployeesUsecase (private val repository: EmployeeRepository) {

    suspend operator fun invoke(){
        val sampleList = listOf(
            Employee(   0,"Jhon", "Driver", "Development"),
            Employee(   1, "Jhon", "Driver", "Development"),
            Employee(   3,"Jhon", "Driver", "Development"),
        )

        repository.inserAlltEmployee(sampleList)
    }
}