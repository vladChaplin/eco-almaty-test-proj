package kz.enactus.ecoalmaty.android.models

data class Employee(
    val id: String,
    val firstName: String,
    val lastName: String,
    val fatherName: String?,
    val dateOfBirth: String,
    val hireDate: String,
    val phone: String,
    val education: String,
    val status: String
)
