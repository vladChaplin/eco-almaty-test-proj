package kz.enactus.ecoalmaty.api.config

import kz.enactus.ecoalmaty.api.utils.encoder.BCryptPasswordEncoder
import kz.enactus.ecoalmaty.api.utils.encoder.PasswordEncoder
import kz.enactus.ecoalmaty.api.utils.token.RandomStringTokenGenerator
import kz.enactus.ecoalmaty.api.utils.token.TokenGenerator
import kz.enactus.ecoalmaty.api.utils.verification.VerificationCodeGenerator
import org.springframework.beans.factory.annotation.Value
import org.springframework.context.annotation.Bean
import org.springframework.context.annotation.Configuration

@Configuration
class BeanConfig {

    @Value("\${app.security.salt-rounds}")
    private var saltRounds: Int = 0

    @Bean
    fun apiKeyGenerator(): TokenGenerator = RandomStringTokenGenerator(128)

    @Bean
    fun passwordEncoder(): PasswordEncoder = BCryptPasswordEncoder(saltRounds)

    @Bean
    fun verificationCodeGenerator(): VerificationCodeGenerator = VerificationCodeGenerator()

}