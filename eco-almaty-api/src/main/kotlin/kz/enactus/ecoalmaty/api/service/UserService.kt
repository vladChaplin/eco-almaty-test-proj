package kz.enactus.ecoalmaty.api.service

import kz.enactus.ecoalmaty.api.model.entity.User
import kz.enactus.ecoalmaty.api.repository.UserRepository
import kz.enactus.ecoalmaty.api.exception.UserNotFoundException
import org.springframework.stereotype.Service

@Service
class UserService(
    private val userRepository: UserRepository,
) {

    fun getById(userId: Long): User {
        return userRepository.findById(userId).orElseThrow { UserNotFoundException() }
    }

}