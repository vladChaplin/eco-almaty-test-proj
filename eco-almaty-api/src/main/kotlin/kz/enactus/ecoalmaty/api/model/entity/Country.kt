package kz.enactus.ecoalmaty.api.model.entity

import jakarta.persistence.*

@Entity
@Table(name = "t_countries")
data class Country(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    var id: Long? = null,

    @Column(name = "name", length = 100)
    var name: String? = null,
)