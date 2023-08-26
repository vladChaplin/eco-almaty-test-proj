package kz.enactus.ecoalmaty.api.service

import kz.enactus.ecoalmaty.api.model.entity.User
import kz.enactus.ecoalmaty.api.model.request.SignUpRequest
import kz.enactus.ecoalmaty.api.model.response.SignUpResponse
import kz.enactus.ecoalmaty.api.repository.UserRepository
import kz.enactus.ecoalmaty.api.utils.encoder.PasswordEncoder
import kz.enactus.ecobox.api.exception.EmailIsAlreadyRegisteredException
import org.springframework.stereotype.Service
import org.springframework.transaction.annotation.Transactional

@Service
class SignUpService(
    private val userRepository: UserRepository,
    private val roleService: RoleService,
    private val passwordEncoder: PasswordEncoder,
) {

    @Transactional
    fun signUp(request: SignUpRequest): SignUpResponse {
        userRepository.findByEmail(request.email).ifPresent { throw EmailIsAlreadyRegisteredException() }

        val savedUser = User(
            username = request.username,
            email = request.email,
            password = passwordEncoder.hash(request.password),
            countryId = request.countryId,
            cityId = request.cityId
        ).let(userRepository::save)

        roleService.addRoleForUser(savedUser.id!!, 1)

        return SignUpResponse(
            userId = savedUser.id,
            username = savedUser.username,
            email = savedUser.email,
            countryId = savedUser.countryId,
            cityId = savedUser.cityId
        )
    }

}