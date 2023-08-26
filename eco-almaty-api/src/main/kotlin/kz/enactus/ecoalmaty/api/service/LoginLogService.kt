package kz.enactus.ecoalmaty.api.service

import kz.enactus.ecoalmaty.api.model.entity.LoginLog
import kz.enactus.ecoalmaty.api.repository.LoginLogRepository
import org.springframework.stereotype.Service

@Service
class LoginLogService(private val loginLogRepository: LoginLogRepository) {

    fun save(userId: Long): LoginLog {
        return LoginLog.of(userId).let { loginLogRepository.save(it) }
    }

}