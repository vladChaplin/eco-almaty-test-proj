package kz.enactus.ecoalmaty.api.model.request

data class SignInRequest(
    val email: String,
    val password: String,
)