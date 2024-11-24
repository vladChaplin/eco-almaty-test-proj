package kz.enactus.ecoalmaty.android.services

import android.content.Context
import android.content.SharedPreferences
import android.os.Handler
import android.os.Looper
import android.widget.Toast
import com.google.gson.Gson
import okhttp3.*
import okhttp3.MediaType.Companion.toMediaTypeOrNull
import okhttp3.RequestBody.Companion.toRequestBody
import java.io.IOException

// Mодель данных для запроса регистрации
data class SignUpRequest(
    val username: String,
    val email: String,
    val password: String,
    val role: List<String>
)

// Модель данных для запроса авторизации
data class AuthRequest(
    val username: String,
    val password: String
)

// Функция для регистрации пользователя
fun registerUser(context: Context, request: SignUpRequest, onResult: (Boolean, String) -> Unit) {
    val client = OkHttpClient()
    val gson = Gson()
    val jsonBody = gson.toJson(request)
    val body = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())

    val httpRequest = Request.Builder()
        .url("http://10.0.2.2:8080/api/auth/signup")
        .post(body)
        .build()

    client.newCall(httpRequest).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(context, "Ошибка регистрации: ${e.message}", Toast.LENGTH_LONG).show()
                onResult(false, "Ошибка регистрации: ${e.message}")
            }
        }

        override fun onResponse(call: Call, response: Response) {
            if (response.isSuccessful) {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(context, "Регистрация успешна", Toast.LENGTH_LONG).show()
                    onResult(true, "Регистрация успешна")
                }
            } else {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(context, "Ошибка регистрации: ${response.message}", Toast.LENGTH_LONG).show()
                    onResult(false, "Ошибка регистрации: ${response.message}")
                }
            }
        }
    })
}

// Модель данных для ответа авторизации
data class AuthResponse(
    val token: String,
    val type: String,
    val id: Int,
    val username: String,
    val email: String,
    val roles: List<String>
)

fun authUser(context: Context, request: AuthRequest, onResult: (Boolean, AuthResponse?) -> Unit) {
    val client = OkHttpClient()
    val gson = Gson()
    val jsonBody = gson.toJson(request)
    val body = jsonBody.toRequestBody("application/json".toMediaTypeOrNull())

    val httpRequest = Request.Builder()
        .url("http://10.0.2.2:8080/api/auth/signin")
        .post(body)
        .build()

    client.newCall(httpRequest).enqueue(object : Callback {
        override fun onFailure(call: Call, e: IOException) {
            Handler(Looper.getMainLooper()).post {
                Toast.makeText(context, "Ошибка авторизации: ${e.message}", Toast.LENGTH_LONG).show()
                onResult(false, null)
            }
        }

        override fun onResponse(call: Call, response: Response) {
            if (response.isSuccessful) {
                val authResponse = gson.fromJson(response.body?.string(), AuthResponse::class.java)

                // Save token to SharedPreferences
                saveToken(context, authResponse.token)

                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(context, "Авторизация успешна", Toast.LENGTH_LONG).show()
                    onResult(true, authResponse)
                }
            } else {
                Handler(Looper.getMainLooper()).post {
                    Toast.makeText(context, "Ошибка авторизации: ${response.message}", Toast.LENGTH_LONG).show()
                    onResult(false, null)
                }
            }
        }
    })
}

// Function to save token in SharedPreferences
fun saveToken(context: Context, token: String) {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("AuthPrefs", Context.MODE_PRIVATE)
    val editor = sharedPreferences.edit()
    editor.putString("jwt_token", token)
    editor.apply()
}

// Function to retrieve token from SharedPreferences
fun getToken(context: Context): String? {
    val sharedPreferences: SharedPreferences = context.getSharedPreferences("AuthPrefs", Context.MODE_PRIVATE)
    return sharedPreferences.getString("jwt_token", null)
}