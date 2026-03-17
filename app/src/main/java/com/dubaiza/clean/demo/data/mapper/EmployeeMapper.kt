package com.dubaiza.clean.demo.data.mapper

import com.dubaiza.clean.demo.data.local.entity.EmployeeEntity
import com.dubaiza.clean.demo.domain.model.Employee

fun Employee.toEntity(): EmployeeEntity {
    return EmployeeEntity(
        id = id,
        name = name,
        designation = designation,
        department = department
    )
}

fun EmployeeEntity.toDomain(): Employee {
    return Employee(
        id = id,
        name = name,
        designation = designation,
        department = department
    )
}

fun List<Employee>.toEntityList(): List<EmployeeEntity> {
    return this.map { it.toEntity() }
}

fun List<EmployeeEntity>.toDomainList(): List<Employee> {
    return this.map { it.toDomain() }
}



/*
employeeDao.insertEmployee(employee.toEntity())
val employees = employeeDao.getAllEmployees().map { list ->
    list.toDomainList()
}*/
