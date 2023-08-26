package kz.enactus.ecoalmaty.api.utils.token

import java.util.*

class RandomStringTokenGenerator(
    private val keySize: Int,
) : TokenGenerator {

    private val random: Random = Random()
    private val characters = ('A'..'Z') + ('a'..'z') + ('0'..'9')

    override fun generate(): String {
        return (1..keySize)
            .map { characters[random.nextInt(characters.size)] }
            .joinToString("")
    }

}