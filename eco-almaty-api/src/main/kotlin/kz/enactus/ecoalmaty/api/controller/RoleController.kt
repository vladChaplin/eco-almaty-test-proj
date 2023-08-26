package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.entity.Role
import kz.enactus.ecoalmaty.api.model.entity.User
import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.service.RoleService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("/api/v1/roles")
class RoleController(
    private val roleService: RoleService,
) {

    @GetMapping("/{userId}")
    fun getUserRolesById(
        @RequestAttribute("roles") roles: List<Role>,
        @RequestAttribute("user") user: User,
        @PathVariable userId: Long,
    ): MessagedResponse<List<Role>> {
        return roleService.getUserRolesById(roles, user, userId).let(MessagedResponse.Companion::of)
    }

}