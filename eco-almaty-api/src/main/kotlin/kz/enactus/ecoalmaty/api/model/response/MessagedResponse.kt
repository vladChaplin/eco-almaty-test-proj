package kz.enactus.ecoalmaty.api.model.response

class MessagedResponse<T>(
    val body: T? = null,
    val message: String? = null,
) {

    companion object {

        fun ofEmpty(message: String) = MessagedResponse(message = message, body = null)

        fun <T> ofBody(body: T) = MessagedResponse(body = body, message = null)

    }

}