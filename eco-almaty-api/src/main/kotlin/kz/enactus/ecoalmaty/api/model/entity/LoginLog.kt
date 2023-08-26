package kz.enactus.ecoalmaty.api.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "t_login_log")
class LoginLog(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(name = "user_id")
    var userId: Long,

    @Column(name = "timestamp")
    var timestamp: LocalDateTime = LocalDateTime.now(),
) {

    companion object {

        fun of(userId: Long): LoginLog = LoginLog(userId = userId)

    }

}