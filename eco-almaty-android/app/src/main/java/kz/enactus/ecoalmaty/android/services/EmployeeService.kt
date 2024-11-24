package kz.enactus.ecoalmaty.android.services

import android.app.Activity
import android.content.Context
import android.widget.Toast
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException
import android.os.Handler
import android.os.Looper
import kz.enactus.ecoalmaty.android.models.Employee

fun addEmployee(
    context: Context,
    token: String,
    employeeData: Map<String, String>,
    onResult: (Boolean, String) -> Unit
) {
    val client = OkHttpClient()
    val gson = Gson()
    val jsonBody = gson.toJson(employeeData)
    val body = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())

    // Логирование токена перед отправкой
    android.util.Log.d("AddEmployee", "Token: Bearer $token")
    android.util.Log.d("AddEmployee", "Request Body: $jsonBody")

    val request = Request.Builder()
        .url("http://10.0.2.2:8080/api/employees/create")
        .addHeader("Authorization", "Bearer $token") // Ensure "Bearer" prefix is added
        .post(body)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            android.util.Log.e("AddEmployee", "Request failed: ${e.message}")
            Handler(Looper.getMainLooper()).post {
                onResult(false, "Ошибка: ${e.message}")
            }
        }

        override fun onResponse(call: Call, response: Response) {
            val responseBody = response.body?.string()
            android.util.Log.d("AddEmployee", "Response Code: ${response.code}")
            android.util.Log.d("AddEmployee", "Response Body: $responseBody")
            if (response.isSuccessful) {
                Handler(Looper.getMainLooper()).post {
                    onResult(true, "Сотрудник успешно добавлен")
                }
            } else {
                Handler(Looper.getMainLooper()).post {
                    val errorMessage = responseBody ?: "Неизвестная ошибка"
                    onResult(false, "Ошибка: ${response.message}. Детали: $errorMessage")
                }
            }
        }
    })
}

fun getEmployees(token: String, onResult: (Boolean, List<Employee>?) -> Unit) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("http://10.0.2.2:8080/api/employees/list")
        .addHeader("Authorization", "Bearer $token")
        .get()
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            onResult(false, null)
        }

        override fun onResponse(call: Call, response: Response) {
            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                val employees = Gson().fromJson(responseBody, Array<Employee>::class.java).toList()
                onResult(true, employees)
            } else {
                onResult(false, null)
            }
        }
    })
}

fun getEmployeeById(token: String, employeeId: String, onResult: (Boolean, Employee?) -> Unit) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("http://10.0.2.2:8080/api/employees/$employeeId")
        .addHeader("Authorization", "Bearer $token")
        .get()
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            onResult(false, null)
        }

        override fun onResponse(call: Call, response: Response) {
            if (response.isSuccessful) {
                val responseBody = response.body?.string()
                val employee = Gson().fromJson(responseBody, Employee::class.java)
                onResult(true, employee)
            } else {
                onResult(false, null)
            }
        }
    })
}

fun updateEmployee(
    context: Context,
    token: String,
    employeeId: String,
    changes: Map<String, String>,
    onResult: (Boolean, String) -> Unit
) {
    val client = OkHttpClient()
    val gson = Gson()
    val jsonBody = gson.toJson(changes)
    val body = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())

    val request = Request.Builder()
        .url("http://10.0.2.2:8080/api/employees/$employeeId")
        .addHeader("Authorization", "Bearer $token")
        .patch(body)
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Handler(Looper.getMainLooper()).post {
                onResult(false, "Ошибка: ${e.message}")
            }
        }

        override fun onResponse(call: Call, response: Response) {
            val responseBody = response.body?.string()
            if (response.isSuccessful) {
                Handler(Looper.getMainLooper()).post {
                    onResult(true, "Данные сотрудника успешно обновлены")
                }
            } else {
                Handler(Looper.getMainLooper()).post {
                    val errorMessage = responseBody ?: "Неизвестная ошибка"
                    onResult(false, "Ошибка: ${response.message}. Детали: $errorMessage")
                }
            }
        }
    })
}

fun deleteEmployee(token: String, employeeId: String, onResult: (Boolean) -> Unit) {
    val client = OkHttpClient()
    val request = Request.Builder()
        .url("http://10.0.2.2:8080/api/employees/$employeeId")
        .addHeader("Authorization", "Bearer $token")
        .delete()
        .build()

    client.newCall(request).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Handler(Looper.getMainLooper()).post {
                onResult(false)
            }
        }

        override fun onResponse(call: Call, response: Response) {
            Handler(Looper.getMainLooper()).post {
                if (response.isSuccessful) {
                    onResult(true)
                } else {
                    onResult(false)
                }
            }
        }
    })
}



