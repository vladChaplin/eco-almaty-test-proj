package kz.enactus.ecoalmaty.api.service

import kz.enactus.ecoalmaty.api.model.entity.Session
import kz.enactus.ecoalmaty.api.model.request.SignInRequest
import kz.enactus.ecoalmaty.api.repository.UserRepository
import kz.enactus.ecoalmaty.api.utils.encoder.PasswordEncoder
import kz.enactus.ecobox.api.exception.UserNotFoundException
import kz.enactus.ecobox.api.exception.WrongCredentialsException
import org.springframework.stereotype.Service

@Service
class SignInService(
    private val userRepository: UserRepository,
    private val sessionService: SessionService,
    private val passwordEncoder: PasswordEncoder,
) {

    fun findByEmail(signInRequest: SignInRequest): Session {
        val user = userRepository.findByEmail(signInRequest.email).orElseThrow { UserNotFoundException() }

        if (!passwordEncoder.check(signInRequest.password, user.password)) {
            throw WrongCredentialsException()
        }

        return sessionService.generateForUser(user.id!!)
    }

}