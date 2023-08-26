package kz.enactus.ecoalmaty.api.model.entity

import jakarta.persistence.Column
import jakarta.persistence.Entity
import jakarta.persistence.GeneratedValue
import jakarta.persistence.GenerationType
import jakarta.persistence.Id
import jakarta.persistence.Table

@Entity
@Table(name = "t_mail_verification")
class MailVerification(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "email")
    val email: String,

    @Column(name = "code")
    val code: String,
) {

    companion object {

        fun of(email: String, code: String) = MailVerification(email = email, code = code)

    }

}