package kz.enactus.ecoalmaty.api.exception.handler

import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: RuntimeException): MessagedResponse<Nothing> {
        exception.printStackTrace()
        return MessagedResponse.ofEmpty(exception.message ?: "ERROR MESSAGE IS NOT PRESENT")
    }

}