package kz.enactus.ecoalmaty.android.components.inputs

import android.widget.Toast
import androidx.compose.foundation.layout.Column
import androidx.compose.runtime.Composable
import androidx.compose.runtime.getValue
import androidx.compose.runtime.mutableStateOf
import androidx.compose.runtime.remember
import androidx.compose.runtime.setValue
import androidx.compose.ui.platform.LocalContext
import kz.enactus.ecoalmaty.android.models.Employee

import android.content.Context
import androidx.compose.foundation.layout.*
import androidx.compose.material3.*
import androidx.compose.runtime.*
import androidx.compose.ui.Modifier
import androidx.compose.ui.platform.LocalContext
import androidx.compose.ui.unit.dp
import kz.enactus.ecoalmaty.android.services.updateEmployee

@OptIn(ExperimentalMaterial3Api::class)
@Composable
fun EmployeeEditForm(
    employee: Employee?,
    token: String,
    employeeId: String,
    onCancel: () -> Unit,
    onSave: () -> Unit
) {
    var firstName by remember { mutableStateOf(employee?.firstName ?: "") }
    var lastName by remember { mutableStateOf(employee?.lastName ?: "") }
    var fatherName by remember { mutableStateOf(employee?.fatherName ?: "") }
    var dateOfBirth by remember { mutableStateOf(employee?.dateOfBirth ?: "") }
    var hireDate by remember { mutableStateOf(employee?.hireDate ?: "") }
    var phone by remember { mutableStateOf(employee?.phone ?: "") }
    var education by remember { mutableStateOf(employee?.education ?: "") }
    var status by remember { mutableStateOf(employee?.status ?: "ACTIVE") }

    val context = LocalContext.current

    fun saveChanges() {
        val changes = mutableMapOf<String, String>()

        if (firstName != employee?.firstName) changes["firstName"] = firstName
        if (lastName != employee?.lastName) changes["lastName"] = lastName
        if (fatherName != employee?.fatherName) changes["fatherName"] = fatherName
        if (dateOfBirth != employee?.dateOfBirth) changes["dateOfBirth"] = dateOfBirth
        if (hireDate != employee?.hireDate) changes["hireDate"] = hireDate
        if (phone != employee?.phone) changes["phone"] = phone
        if (education != employee?.education) changes["education"] = education
        if (status != employee?.status) changes["status"] = status

        updateEmployee(context, token, employeeId, changes) { success, message ->
            Toast.makeText(context, message, Toast.LENGTH_SHORT).show()
            if (success) {
                onSave()
            }
        }
    }

    Column {
        TextField(value = firstName, onValueChange = { firstName = it }, label = { Text("Имя") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = lastName, onValueChange = { lastName = it }, label = { Text("Фамилия") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = fatherName, onValueChange = { fatherName = it }, label = { Text("Отчество") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = dateOfBirth, onValueChange = { dateOfBirth = it }, label = { Text("Дата рождения") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = hireDate, onValueChange = { hireDate = it }, label = { Text("Дата приема на работу") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = phone, onValueChange = { phone = it }, label = { Text("Телефон") })
        Spacer(modifier = Modifier.height(8.dp))
        TextField(value = education, onValueChange = { education = it }, label = { Text("Образование") })
        Spacer(modifier = Modifier.height(16.dp))
        Row {
            Button(onClick = onCancel) {
                Text("Отмена")
            }
            Spacer(modifier = Modifier.width(8.dp))
            Button(onClick = { saveChanges() }) {
                Text("Сохранить")
            }
        }
    }
}