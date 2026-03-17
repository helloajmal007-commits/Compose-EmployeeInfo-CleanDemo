package com.dubaiza.clean.demo.di

import android.content.Context
import com.dubaiza.clean.demo.data.local.database.AppDatabase
import com.dubaiza.clean.demo.data.local.database.EmployeeDatabase
import com.dubaiza.clean.demo.data.repository.EmployeeRepositoryImpl
import com.dubaiza.clean.demo.domain.repository.EmployeeRepository
import com.dubaiza.clean.demo.domain.usecase.DeleteEmployeeUsecase
import com.dubaiza.clean.demo.domain.usecase.GetAllEmployeeUseCase
import com.dubaiza.clean.demo.domain.usecase.GetEmployeeByIdUsecase
import com.dubaiza.clean.demo.domain.usecase.InsertEmployeeUsecase
import com.dubaiza.clean.demo.domain.usecase.InsertEmployeesUsecase

class EmployeeContainer(context: Context) {

    private val database: AppDatabase = EmployeeDatabase.getDatabase(context =context)
    private val employeeDao = database.employeeDao()

    val repository: EmployeeRepository = EmployeeRepositoryImpl(employeeDao)

    val getAllEmployeesUsecase = GetAllEmployeeUseCase(repository)
    val getEmployeeByIdUsecase = GetEmployeeByIdUsecase(repository)
    val insertEmployeeUsecase = InsertEmployeeUsecase(repository)
    val insertEmployeesUsecase = InsertEmployeesUsecase(repository)
    val deleteEmployeeUsecase = DeleteEmployeeUsecase(repository)

}