package kz.enactus.ecoalmaty.api.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "t_roles")
class Role(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long? = null,

    @Column(length = 30)
    val name: String? = null,
)