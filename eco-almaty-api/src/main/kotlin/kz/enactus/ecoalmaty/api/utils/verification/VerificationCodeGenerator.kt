package kz.enactus.ecoalmaty.api.utils.verification

import kotlin.random.Random

class VerificationCodeGenerator {

    private val characters = '0'..'9'

    fun generate(): String {
        return (1..6)
            .map { characters.random(Random) }
            .joinToString("")
    }

}