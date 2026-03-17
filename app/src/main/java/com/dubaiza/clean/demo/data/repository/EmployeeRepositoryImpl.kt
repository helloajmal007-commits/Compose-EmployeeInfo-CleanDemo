package com.dubaiza.clean.demo.data.repository

import com.dubaiza.clean.demo.data.local.dao.EmployeeDao
import com.dubaiza.clean.demo.data.local.entity.EmployeeEntity
import com.dubaiza.clean.demo.data.mapper.toDomain
import com.dubaiza.clean.demo.data.mapper.toEntity
import com.dubaiza.clean.demo.data.mapper.toDomainList
import com.dubaiza.clean.demo.data.mapper.toEntityList
import com.dubaiza.clean.demo.data.mapper.toDomainList
import com.dubaiza.clean.demo.domain.model.Employee
import com.dubaiza.clean.demo.domain.repository.EmployeeRepository
import kotlinx.coroutines.flow.Flow
import kotlinx.coroutines.flow.map

class EmployeeRepositoryImpl(private val employeeDao: EmployeeDao) : EmployeeRepository {
    override suspend fun insertEmployee(employee: Employee) {
        employeeDao.insertEmployee(employee.toEntity())
    }

    override suspend fun inserAlltEmployee(employees: List<Employee>) {
        employeeDao.insertEmployees(employees.toEntityList())
    }

    override fun getAllEmployees(): Flow<List<Employee>> {
        return employeeDao.getAllEmployees()
            .map { entities ->  entities.toDomainList()}
    }

    override suspend fun addEmployee(employee: Employee) {
         employeeDao.insertEmployee(employee.toEntity())
    }

    override suspend fun addEmployees(employees: List<Employee>) {
        employeeDao.insertEmployees(employees.toEntityList())
    }

    override suspend fun updateEmployee(employee: Employee) {
        employeeDao.updateEmployee(employee.toEntity())

    }

    override suspend fun deleteEmployee(employee: Employee) {
        employeeDao.deleteEmployee(employee.toEntity())

    }

    override suspend fun deleteAllEmployees() {
        employeeDao.deleteAllEmployees()

    }

    override suspend fun getEmployeeById(id: Int): Employee? {
       return employeeDao.getEmployeeById(id)?.toDomain()
    }
}