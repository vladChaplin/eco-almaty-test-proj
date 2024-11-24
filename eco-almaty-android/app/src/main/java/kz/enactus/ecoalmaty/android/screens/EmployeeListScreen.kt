package kz.enactus.ecoalmaty.android.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.ExperimentalMaterial3Api
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.material3.TextField
import androidx.compose.material3.TextFieldDefaults
import androidx.compose.runtime.*
import androidx.compose.ui.Alignment
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.components.buttons.AButton
import kz.enactus.ecoalmaty.android.models.Employee
import kz.enactus.ecoalmaty.android.services.getEmployees

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeListScreen(navController: NavController, token: String, userRole: String) {
    val employees = remember { mutableStateListOf<Employee>() }
    val filteredEmployees = remember { mutableStateListOf<Employee>() }
    val context = LocalContext.current
    var searchQuery by remember { mutableStateOf("") }

    // Fetch employees from API
    LaunchedEffect(Unit) {
        getEmployees(token) { success, data ->
            if (success) {
                employees.clear()
                employees.addAll(data ?: emptyList())
                filteredEmployees.clear()
                filteredEmployees.addAll(employees) // Initially, show all employees
            } else {
                Toast.makeText(context, "Ошибка загрузки списка сотрудников", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Column(modifier = Modifier.fillMaxSize()) {
        // Search Bar
        TextField(
            value = searchQuery,
            onValueChange = { query ->
                searchQuery = query
                // Filter employees based on the search query
                filteredEmployees.clear()
                filteredEmployees.addAll(
                    employees.filter { it.lastName.contains(query, ignoreCase = true) }
                )
            },
            placeholder = { Text(text = "Поиск по фамилии") },
            modifier = Modifier
                .fillMaxWidth()
                .padding(8.dp),
            singleLine = true,
            colors = TextFieldDefaults.textFieldColors(
                textColor = Color.Black,
                containerColor = Color.White,
                focusedIndicatorColor = colorResource(id = R.color.colorLightGreen),
                unfocusedIndicatorColor = Color.Gray
            )
        )

        // Employee List
        LazyColumn(
            modifier = Modifier
                .fillMaxSize()
                .padding(8.dp)
        ) {
            items(filteredEmployees) { employee ->
                Row(
                    modifier = Modifier
                        .fillMaxWidth()
                        .padding(8.dp)
                ) {
                    Column(modifier = Modifier.weight(1f)) {
                        Text(
                            text = "ФИО: ${employee.lastName} ${employee.firstName} ${employee.fatherName}",
                            fontSize = 18.sp, // Larger font size
                            color = Color.Black
                        )
                        Spacer(modifier = Modifier.height(4.dp))
                        Text(
                            text = "Телефон: ${employee.phone}",
                            fontSize = 18.sp, // Larger font size
                            color = Color.Black
                        )
                    }
                    // Show "Подробнее" button only if the user is an admin
                    if (userRole == "ROLE_ADMIN") {
                        Button(
                            onClick = {
                                val employeeId = employee.id.toString()
                                android.util.Log.d(
                                    "EmployeeListScreen",
                                    "Navigating to detail screen for employeeId: $employeeId"
                                )
                                navController.navigate("employee_detail_screen/$employeeId")
                            },
                            modifier = Modifier.padding(start = 8.dp)
                        ) {
                            Text(text = "Подробнее")
                        }
                    }
                }
            }
        }
    }
}