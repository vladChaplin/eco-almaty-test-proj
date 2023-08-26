package kz.enactus.ecoalmaty.api.service

import kz.enactus.ecoalmaty.api.model.entity.ExceptionLog
import kz.enactus.ecoalmaty.api.repository.ExceptionLogRepository
import org.springframework.stereotype.Service

@Service
class ExceptionLogService(private val exceptionLogRepository: ExceptionLogRepository) {

    fun save(cause: String, message: String): ExceptionLog {
        return ExceptionLog.of(cause, message).let { exceptionLogRepository.save(it) }
    }

}