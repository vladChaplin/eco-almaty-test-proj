package kz.enactus.ecoalmaty.api.model.entity

import jakarta.persistence.*
import java.time.LocalDateTime

@Entity
@Table(name = "t_sessions")
class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "token")
    var token: String? = null,

    @Column(name = "user_id")
    var userId: Long? = null,

    @Column(name = "expires_at")
    var expiresAt: LocalDateTime? = null,
)