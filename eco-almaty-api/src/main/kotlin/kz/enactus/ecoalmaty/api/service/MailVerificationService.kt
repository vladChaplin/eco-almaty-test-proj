package kz.enactus.ecoalmaty.api.service

import kz.enactus.ecoalmaty.api.exception.InvalidVerificationCodeException
import kz.enactus.ecoalmaty.api.model.entity.MailVerification
import kz.enactus.ecoalmaty.api.model.request.MailVerificationCheckRequest
import kz.enactus.ecoalmaty.api.model.request.MailVerificationSendRequest
import kz.enactus.ecoalmaty.api.repository.MailVerificationRepository
import kz.enactus.ecoalmaty.api.utils.verification.VerificationCodeGenerator
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class MailVerificationService(
    private val mailService: MailService,
    private val codeGenerator: VerificationCodeGenerator,
    private val mailVerificationRepository: MailVerificationRepository,
) {

    @Transactional
    fun generateCode(request: MailVerificationSendRequest): Boolean {
        val verification = MailVerification
            .of(request.email, codeGenerator.generate())
            .let { mailVerificationRepository.save(it) }

        mailService.send(
            request.email,
            "Подтверждение регистрации аккаунта",
            "Для подтверждения регистрации введите 6-значный код в поле ввода в приложении: ${verification.code}"
        )

        return true
    }

    fun verify(request: MailVerificationCheckRequest): Boolean {
        val verification = mailVerificationRepository
            .findByCodeAndEmail(request.code, request.email)
            .orElseThrow { throw InvalidVerificationCodeException() }

        mailVerificationRepository.delete(verification)

        return true
    }

}