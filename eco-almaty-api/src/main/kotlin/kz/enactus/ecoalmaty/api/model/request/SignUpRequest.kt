package kz.enactus.ecoalmaty.api.model.request

data class SignUpRequest(
    val username: String,
    val email: String,
    val password: String,
    val countryId: Long,
    val cityId: Long,
)