package kz.enactus.ecoalmaty.android.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.text.font.FontWeight
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.models.Employee
import kz.enactus.ecoalmaty.android.services.getEmployeeById


@Composable
fun EmployeeDetailScreen(navController: NavController, employeeId: String, token: String) {
    var employee by remember { mutableStateOf<Employee?>(null) }
    val context = LocalContext.current

    // Получение данных сотрудника
    LaunchedEffect(employeeId) {
        getEmployeeById(token, employeeId) { success, data ->
            if (success) {
                employee = data
            } else {
                Toast.makeText(context, "Ошибка загрузки данных сотрудника", Toast.LENGTH_SHORT).show()
            }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column {
            if (employee != null) {
                Text(text = "ФИО: ${employee?.firstName} ${employee?.lastName} ${employee?.fatherName}")
                Text(text = "Дата рождения: ${employee?.dateOfBirth}")
                Text(text = "Дата приема на работу: ${employee?.hireDate}")
                Text(text = "Телефон: ${employee?.phone}")
                Text(text = "Образование: ${employee?.education}")
                Text(text = "Статус: ${employee?.status}")
            } else {
                Text(text = "Загрузка данных сотрудника...")
            }

            Spacer(modifier = Modifier.height(16.dp))
            Button(onClick = { navController.popBackStack() }) {
                Text(text = "Назад")
            }
        }
    }
}