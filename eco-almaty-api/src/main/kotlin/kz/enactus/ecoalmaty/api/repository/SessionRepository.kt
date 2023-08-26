package kz.enactus.ecoalmaty.api.repository

import kz.enactus.ecoalmaty.api.model.entity.Session
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface SessionRepository : JpaRepository<Session, Long> {

    fun findByToken(token: String): Optional<Session>

    fun deleteByToken(token: String): Int

}