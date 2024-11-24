package kz.enactus.ecoalmaty.android.screens

import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.material3.Button
import androidx.compose.material3.ButtonDefaults
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
import kz.enactus.ecoalmaty.android.components.inputs.EmployeeEditForm
import kz.enactus.ecoalmaty.android.models.Employee
import kz.enactus.ecoalmaty.android.services.deleteEmployee
import kz.enactus.ecoalmaty.android.services.getEmployeeById
import android.os.Handler
import android.os.Looper
import androidx.compose.ui.Alignment

@Composable
fun EmployeeDetailScreen(navController: NavController, employeeId: String, token: String) {
    var employee by remember { mutableStateOf<Employee?>(null) }
    var isEditing by remember { mutableStateOf(false) }
    val context = LocalContext.current

    // Fetching employee details
    LaunchedEffect(employeeId) {
        getEmployeeById(token, employeeId) { success, data ->
            if (success) {
                employee = data
            } else {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(context, "Ошибка загрузки данных сотрудника", Toast.LENGTH_SHORT).show()
                }
            }
        }
    }

    Surface(
        modifier = Modifier
            .fillMaxSize()
            .padding(16.dp)
    ) {
        Column(
            modifier = Modifier
                .fillMaxSize()
                .padding(16.dp),
            verticalArrangement = Arrangement.Center,
            horizontalAlignment = Alignment.CenterHorizontally
        ) {
            if (!isEditing) {
                if (employee != null) {
                    Text(
                        text = "ФИО: ${employee?.firstName} ${employee?.lastName} ${employee?.fatherName}",
                        fontSize = 20.sp,
                        fontWeight = FontWeight.Bold,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Дата рождения: ${employee?.dateOfBirth}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Дата приема на работу: ${employee?.hireDate}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Телефон: ${employee?.phone}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Образование: ${employee?.education}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 8.dp)
                    )
                    Text(
                        text = "Статус: ${employee?.status}",
                        fontSize = 18.sp,
                        modifier = Modifier.padding(bottom = 16.dp)
                    )
                } else {
                    Text(
                        text = "Загрузка данных сотрудника...",
                        fontSize = 18.sp,
                        fontWeight = FontWeight.Medium
                    )
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Back Button
                Button(onClick = { navController.popBackStack() }) {
                    Text(text = "Назад")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Edit Button (Yellow)
                Button(
                    onClick = { isEditing = true },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Yellow,
                        contentColor = Color.Black
                    )
                ) {
                    Text(text = "Изменить")
                }

                Spacer(modifier = Modifier.height(16.dp))

                // Delete Button (Red)
                Button(
                    onClick = {
                        deleteEmployee(token, employeeId) { success ->
                            if (success) {
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(context, "Сотрудник удалён", Toast.LENGTH_SHORT).show()
                                    navController.popBackStack()
                                }
                            } else {
                                Handler(Looper.getMainLooper()).post {
                                    Toast.makeText(context, "Ошибка удаления сотрудника", Toast.LENGTH_SHORT).show()
                                }
                            }
                        }
                    },
                    colors = ButtonDefaults.buttonColors(
                        containerColor = Color.Red,
                        contentColor = Color.White
                    )
                ) {
                    Text(text = "Удалить")
                }
            } else {
                EmployeeEditForm(
                    employee = employee,
                    token = token,
                    employeeId = employeeId,
                    onCancel = { isEditing = false },
                    onSave = {
                        isEditing = false
                        navController.popBackStack() // Return to the previous screen after saving
                    }
                )
            }
        }
    }
}