package kz.enactus.ecoalmaty.api.repository

import kz.enactus.ecoalmaty.api.model.entity.MailVerification
import org.springframework.data.jpa.repository.JpaRepository
import java.util.Optional

interface MailVerificationRepository : JpaRepository<MailVerification, Long> {

    fun findByCodeAndEmail(code: String, email: String): Optional<MailVerification>

}