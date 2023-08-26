package kz.enactus.ecoalmaty.api.service

import kz.enactus.ecoalmaty.api.model.entity.Role
import kz.enactus.ecoalmaty.api.model.entity.User
import kz.enactus.ecoalmaty.api.repository.RoleRepository
import org.springframework.stereotype.Service

@Service
class RoleService(
    private val roleRepository: RoleRepository,
) {

    fun getUserRolesById(roles: List<Role>, user: User, userId: Long): List<Role> {
        return roleRepository.getAllForUserId(userId)
    }

    fun addRoleForUser(userId: Long, roleId: Long) {
        roleRepository.addForUser(userId, roleId)
    }

}