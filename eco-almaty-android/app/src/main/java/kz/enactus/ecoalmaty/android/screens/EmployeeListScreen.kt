package kz.enactus.ecoalmaty.android.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.lazy.LazyColumn
import androidx.compose.foundation.lazy.items
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
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

@Composable
fun EmployeeListScreen(navController: NavController, token: String) {
    val employees = remember { mutableStateListOf<Employee>() }
    val context = LocalContext.current

    // Получение данных сотрудников
    LaunchedEffect(Unit) {
        getEmployees(token) { success, data ->
            if (success) {
                employees.clear()
                employees.addAll(data ?: emptyList())
                data?.forEach { employee ->
                    android.util.Log.d("EmployeeListScreen", "Employee ID: ${employee.id}")
                }
            } else {
                Toast.makeText(context, "Ошибка загрузки списка сотрудников", Toast.LENGTH_SHORT).show()
            }
        }
    }

    LazyColumn {
        items(employees) { employee ->
            Row(
                modifier = Modifier
                    .fillMaxWidth()
                    .padding(8.dp)
            ) {
                Column(modifier = Modifier.weight(1f)) {
                    Text(text = "ФИО: ${employee.firstName} ${employee.lastName}")
                    Text(text = "Дата рождения: ${employee.dateOfBirth}")
                }
                Button(
                    onClick = {
                        val employeeId = employee.id.toString() // Преобразуем ID в строку
                        android.util.Log.d("EmployeeListScreen", "Navigating to detail screen for employeeId: $employeeId")
                        navController.navigate("employee_detail_screen/$employeeId")
                    }
                ) {
                    Text(text = "Подробнее")
                }
            }
        }
    }
}