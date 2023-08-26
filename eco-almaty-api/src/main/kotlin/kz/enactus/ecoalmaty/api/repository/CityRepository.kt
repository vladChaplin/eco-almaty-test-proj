package kz.enactus.ecoalmaty.api.repository

import kz.enactus.ecoalmaty.api.model.entity.City
import kz.enactus.ecoalmaty.api.model.entity.Country
import org.springframework.data.jpa.repository.JpaRepository
import java.util.*

interface CityRepository : JpaRepository<City, Long> {

    fun findByCountryId(countryId: Long): Optional<List<Country>>

}