package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.entity.Country
import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.repository.CityRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PathVariable
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/cities")
class CityController(
    private val cityRepository: CityRepository,
) {

    @GetMapping("/public/{countryId}")
    fun getAll(@PathVariable countryId: Long): MessagedResponse<List<Country>> {
        return cityRepository.findByCountryId(countryId)
            .orElseThrow { throw RuntimeException("") }
            .let(MessagedResponse.Companion::of)
    }

}