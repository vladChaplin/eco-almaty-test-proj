package kz.enactus.ecoalmaty.api.service

import org.springframework.mail.SimpleMailMessage
import org.springframework.mail.javamail.JavaMailSender
import org.springframework.stereotype.Service

@Service
class MailService(private val mailSender: JavaMailSender) {

    fun send(to: String, subject: String, text: String) {
        SimpleMailMessage().apply {
            this.setTo(to)
            this.subject = subject
            this.text = text
        }.let { mailSender.send(it) }
    }

}