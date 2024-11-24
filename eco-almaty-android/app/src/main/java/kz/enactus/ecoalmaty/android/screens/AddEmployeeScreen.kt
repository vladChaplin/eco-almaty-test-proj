package kz.enactus.ecoalmaty.android.screens

import android.app.DatePickerDialog
import android.widget.Toast
import androidx.compose.foundation.layout.*
import androidx.compose.foundation.text.KeyboardOptions
import androidx.compose.material3.Surface
import androidx.compose.material3.Text
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.graphics.Color
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.res.colorResource
import androidx.compose.ui.res.stringResource
import androidx.compose.ui.text.input.ImeAction
import androidx.compose.ui.text.input.KeyboardType
import androidx.compose.ui.unit.dp
import androidx.compose.ui.unit.sp
import androidx.navigation.NavController
import kz.enactus.ecoalmaty.android.R
import kz.enactus.ecoalmaty.android.components.inputs.ACustomTextField
import kz.enactus.ecoalmaty.android.components.buttons.AButton
import kz.enactus.ecoalmaty.android.services.addEmployee
import java.util.Calendar

@Composable
fun AddEmployeeScreen(navController: NavController, token: String) {
    var firstName by remember { mutableStateOf("") }
    var lastName by remember { mutableStateOf("") }
    var fatherName by remember { mutableStateOf("") }
    var dateOfBirth by remember { mutableStateOf("") }
    var hireDate by remember { mutableStateOf("") }
    var phone by remember { mutableStateOf("") }
    var education by remember { mutableStateOf("") }
    var status by remember { mutableStateOf("ACTIVE") }
    var username by remember { mutableStateOf("") }

    val context = LocalContext.current

    // Функция для вызова DatePicker
    fun showDatePicker(onDateSelected: (String) -> Unit) {
        val calendar = Calendar.getInstance()
        val year = calendar.get(Calendar.YEAR)
        val month = calendar.get(Calendar.MONTH)
        val day = calendar.get(Calendar.DAY_OF_MONTH)

        DatePickerDialog(
            context,
            { _, selectedYear, selectedMonth, selectedDay ->
                val formattedDate = String.format("%04d-%02d-%02d", selectedYear, selectedMonth + 1, selectedDay)
                onDateSelected(formattedDate)
            },
            year,
            month,
            day
        ).show()
    }

    Surface(
        color = colorResource(id = R.color.colorWhiteBackground),
        modifier = Modifier
            .fillMaxSize()
            .padding(32.dp)
    ) {
        Column {
            Spacer(modifier = Modifier.height(16.dp))
            ACustomTextField(value = firstName, onValueChange = { firstName = it }, label = "Имя")
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(value = lastName, onValueChange = { lastName = it }, label = "Фамилия")
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(value = fatherName, onValueChange = { fatherName = it }, label = "Отчество")
            Spacer(modifier = Modifier.height(8.dp))

            // Поле для выбора даты рождения
            ACustomTextField(
                value = dateOfBirth,
                onValueChange = { dateOfBirth = it },
                label = "Дата рождения",
                readOnly = true,
                onClick = {
                    showDatePicker { selectedDate ->
                        dateOfBirth = selectedDate
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

            // Поле для выбора даты приема на работу
            ACustomTextField(
                value = hireDate,
                onValueChange = { hireDate = it },
                label = "Дата приема на работу",
                readOnly = true,
                onClick = {
                    showDatePicker { selectedDate ->
                        hireDate = "${selectedDate}T00:00:00"
                    }
                }
            )
            Spacer(modifier = Modifier.height(8.dp))

            ACustomTextField(value = phone, onValueChange = { phone = it }, label = "Телефон")
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(value = education, onValueChange = { education = it }, label = "Образование")
            Spacer(modifier = Modifier.height(8.dp))
            ACustomTextField(value = username, onValueChange = { username = it }, label = "Логин")
            Spacer(modifier = Modifier.height(16.dp))

            AButton(
                onClick = {
                    val employeeData = mapOf(
                        "firstName" to firstName,
                        "lastName" to lastName,
                        "fatherName" to fatherName,
                        "dateOfBirth" to dateOfBirth,
                        "hireDate" to hireDate,
                        "phone" to phone,
                        "education" to education,
                        "status" to status,
                        "username" to username
                    )

                    addEmployee(context, token, employeeData) { success, message ->
                        if (success) {
                            Toast.makeText(context, "Сотрудник добавлен", Toast.LENGTH_SHORT).show()
                            // Переход на экран со списком сотрудников
                            navController.navigate("employee_list_screen")
                        } else {
                            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
                        }
                    }
                },
                labelValue = "Добавить сотрудника",
                backgroundColor = colorResource(id = R.color.colorGreen),
                textColor = Color.White
            )
        }
    }
}



