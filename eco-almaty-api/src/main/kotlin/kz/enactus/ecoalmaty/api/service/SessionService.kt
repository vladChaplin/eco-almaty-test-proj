package kz.enactus.ecoalmaty.api.service

import jakarta.transaction.Transactional
import kz.enactus.ecoalmaty.api.model.entity.Session
import kz.enactus.ecoalmaty.api.repository.SessionRepository
import kz.enactus.ecoalmaty.api.utils.token.TokenGenerator
import kz.enactus.ecobox.api.exception.SessionNotFoundException
import org.springframework.stereotype.Service
import java.time.LocalDateTime

@Service
class SessionService(
    private val sessionRepository: SessionRepository,
    private val tokenGenerator: TokenGenerator,
) {

    fun findByToken(token: String): Session {
        return sessionRepository.findByToken(token).orElseThrow { SessionNotFoundException() }
    }

    fun generateForUser(userId: Long): Session {
        return sessionRepository.save(Session(
            token = tokenGenerator.generate(),
            userId = userId,
            expiresAt = LocalDateTime.now().plusDays(7)
        ))
    }

    @Transactional
    fun invalidate(token: String): Boolean {
        return sessionRepository.deleteByToken(token) > 0
    }

}