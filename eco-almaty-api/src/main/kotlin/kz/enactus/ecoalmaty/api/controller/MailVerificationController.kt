package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.request.MailVerificationCheckRequest
import kz.enactus.ecoalmaty.api.model.request.MailVerificationSendRequest
import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.service.MailVerificationService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/verification/public")
class MailVerificationController(private val mailVerificationService: MailVerificationService) {

    @PostMapping("/generate-code")
    fun generateCode(@RequestBody verificationRequest: MailVerificationSendRequest): MessagedResponse<Boolean> {
        return mailVerificationService.generateCode(verificationRequest).let(MessagedResponse.Companion::of)
    }

    @PostMapping("/verify")
    fun checkVerification(@RequestBody request: MailVerificationCheckRequest): MessagedResponse<Boolean> {
        return mailVerificationService.verify(request).let(MessagedResponse.Companion::of)
    }

}