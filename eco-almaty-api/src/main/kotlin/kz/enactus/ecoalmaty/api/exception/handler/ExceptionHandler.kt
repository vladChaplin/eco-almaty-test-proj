package kz.enactus.ecoalmaty.api.exception.handler

import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.service.ExceptionLogService
import org.springframework.web.bind.annotation.ExceptionHandler
import org.springframework.web.bind.annotation.RestControllerAdvice

@RestControllerAdvice
class ExceptionHandler(private val exceptionLogService: ExceptionLogService) {

    @ExceptionHandler(Exception::class)
    fun handleException(exception: RuntimeException): MessagedResponse<Nothing> {
        exception.printStackTrace()

        return exceptionLogService.save(exception.javaClass.simpleName, exception.message ?: "ERROR MESSAGE IS NOT PRESENT")
            .let { MessagedResponse.empty(it.message) }
    }

}