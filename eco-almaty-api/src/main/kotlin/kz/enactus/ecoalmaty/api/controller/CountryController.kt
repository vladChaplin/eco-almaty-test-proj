package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.entity.Country
import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.repository.CountryRepository
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/api/v1/countries")
class CountryController(
    private val countryRepository: CountryRepository,
) {

    @GetMapping("/public")
    fun getAll(): MessagedResponse<List<Country>> {
        return countryRepository.findAll().let(MessagedResponse.Companion::ofBody)
    }

}