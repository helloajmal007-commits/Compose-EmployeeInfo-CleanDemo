package com.dubaiza.clean.demo

import android.os.Bundle
import androidx.activity.ComponentActivity
import androidx.activity.compose.setContent
import androidx.activity.enableEdgeToEdge
import androidx.lifecycle.viewmodel.compose.viewModel
import com.dubaiza.clean.demo.di.EmployeeContainer
import com.dubaiza.clean.demo.feature.employee.presentation.EmployeeViewModel
import com.dubaiza.clean.demo.feature.employee.presentation.EmployeeViewModelFactory
import com.dubaiza.clean.demo.core.ui.theme.CleanDemoTheme
import com.dubaiza.clean.demo.navigation.AppNavGraph

class MainActivity : ComponentActivity() {

    override fun onCreate(savedInstanceState: Bundle?) {
        super.onCreate(savedInstanceState)
        var employeeContainer = EmployeeContainer(applicationContext)
        enableEdgeToEdge()
        setContent {
            CleanDemoTheme {
                val viewModel: EmployeeViewModel = viewModel(
                    factory = EmployeeViewModelFactory(
                        getAllEmployeeUseCase = employeeContainer.getAllEmployeesUsecase,
                        insertEmployeeUsecase = employeeContainer.insertEmployeeUsecase,
                        insertEmployeesUsecase = employeeContainer.insertEmployeesUsecase,
                        deleteEmployeeUsecase = employeeContainer.deleteEmployeeUsecase

                    )
                )

                AppNavGraph(viewModel)

                /*EmployeeScreen(viewModel) {
                }*/
            }
        }
    }
}

