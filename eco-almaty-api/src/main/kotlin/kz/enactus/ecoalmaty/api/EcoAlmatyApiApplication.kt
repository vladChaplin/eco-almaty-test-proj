package kz.enactus.ecoalmaty.api

import org.springframework.boot.autoconfigure.SpringBootApplication
import org.springframework.boot.runApplication
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RestController
import java.time.LocalDateTime
import java.time.format.DateTimeFormatter

@RestController
@SpringBootApplication
class EcoAlmatyApiApplication {

    private val dateTimeFormatter: DateTimeFormatter = DateTimeFormatter.ofPattern("yyyy.MM.dd-SSSSSS")
    private val version: String = dateTimeFormatter.format(LocalDateTime.now())

    @GetMapping("/api/v1/version")
    fun getVersion(): String = version

}

fun main(args: Array<String>) {
    runApplication<EcoAlmatyApiApplication>(*args)
}
