package kz.enactus.ecoalmaty.api.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "t_users")
class User(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(length = 150)
    val username: String,

    @Column(length = 150)
    val email: String,

    @Column(length = 255)
    val password: String,

    val countryId: Long,

    val cityId: Long,
)