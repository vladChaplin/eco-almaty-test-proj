package kz.enactus.ecoalmaty.api.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "t_exception_log")
class ExceptionLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "cause")
    var cause: String,

    @Column(name = "message")
    var message: String,

    @Column(name = "timestamp")
    var timestamp: LocalDateTime = LocalDateTime.now(),
) {

    companion object {

        fun of(cause: String, message: String) = ExceptionLog(cause = cause, message = message)

    }

}