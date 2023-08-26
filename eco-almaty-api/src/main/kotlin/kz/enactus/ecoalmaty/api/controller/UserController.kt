package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.entity.User
import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.service.UserService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/users")
class UserController(
    private val userService: UserService,
) {

    @GetMapping("/{userId}")
    fun getUserById(
        @PathVariable userId: Long,
    ): MessagedResponse<User> {
        return userService.getById(userId).let(MessagedResponse.Companion::ofBody)
    }

}