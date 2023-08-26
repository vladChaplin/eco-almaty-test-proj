package kz.enactus.ecoalmaty.api.utils.token

import java.util.*

class UuidTokenGenerator : TokenGenerator {

    override fun generate() = UUID.randomUUID().toString()

}