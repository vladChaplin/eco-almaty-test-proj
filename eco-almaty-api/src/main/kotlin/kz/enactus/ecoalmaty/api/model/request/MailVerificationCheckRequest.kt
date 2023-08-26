package kz.enactus.ecoalmaty.api.model.request

data class MailVerificationCheckRequest(
    val email: String,
    val code: String
)