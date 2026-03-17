package com.dubaiza.clean.demo.navigation

sealed class Routes(val route: String) {
    object Splash : Routes("splash")
    object EmployeeList : Routes("employee_list")
    object AddEmployee : Routes("add_employee")
}