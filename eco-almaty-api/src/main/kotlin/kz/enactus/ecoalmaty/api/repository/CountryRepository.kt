package kz.enactus.ecoalmaty.api.repository

import kz.enactus.ecoalmaty.api.model.entity.Country
import org.springframework.data.jpa.repository.JpaRepository

interface CountryRepository : JpaRepository<Country, Long>