package kz.enactus.ecoalmaty.api.model.response

data class SignUpResponse(
    val userId: Long? = null,
    val username: String? = null,
    val email: String? = null,
    val countryId: Long? = null,
    val cityId: Long? = null,
)