package com.dubaiza.clean.demo.navigation

import androidx.compose.runtime.Composable
import androidx.navigation.compose.NavHost
import androidx.navigation.compose.composable
import androidx.navigation.compose.rememberNavController
import com.dubaiza.clean.demo.feature.employee.presentation.EmployeeViewModel
import com.dubaiza.clean.demo.feature.employee.presentation.screens.AddEmployeeScreen
import com.dubaiza.clean.demo.feature.employee.presentation.EmployeeScreen
import com.dubaiza.clean.demo.feature.splash.presentation.SplashScreen

@Composable
fun AppNavGraph(viewModel: EmployeeViewModel) {

    val navController = rememberNavController()

    NavHost(
        navController = navController,
        startDestination = Routes.Splash.route
    ) {

        // 🔥 Splash Screen
        composable(Routes.Splash.route) {
            SplashScreen(
                onNavigate = {
                    navController.navigate(Routes.EmployeeList.route) {
                        popUpTo(Routes.Splash.route) { inclusive = true }
                    }
                }
            )
        }

        // Employee List Screen
        composable(Routes.EmployeeList.route) {
            EmployeeScreen(
                viewModel = viewModel,
                onAddEmployee = {
                    navController.navigate(Routes.AddEmployee.route)
                }
            )
        }

        // Add Employee Screen
        composable(Routes.AddEmployee.route) {
            AddEmployeeScreen(
                onSave = { employee ->
                    viewModel.addEmployee(employee)
                    navController.popBackStack()
                },
                onBack = {
                    navController.popBackStack()
                }
            )
        }
    }
}