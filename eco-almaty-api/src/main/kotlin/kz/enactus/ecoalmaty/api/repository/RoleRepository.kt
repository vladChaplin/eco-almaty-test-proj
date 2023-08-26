package kz.enactus.ecoalmaty.api.repository

import kz.enactus.ecoalmaty.api.model.entity.Role
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Modifying
import org.springframework.data.jpa.repository.Query

interface RoleRepository : JpaRepository<Role, Long> {

    @Query("""
        SELECT id, name
        FROM t_roles
            JOIN t_users_roles user_role ON t_roles.id = user_role.role_id
        WHERE user_id = :userId 
    """, nativeQuery = true)
    fun getAllForUserId(userId: Long): List<Role>

    @Modifying
    @Query("""
        INSERT INTO t_users_roles (user_id, role_id)
        VALUE (:userId, :roleId)
    """, nativeQuery = true)
    fun addForUser(userId: Long, roleId: Long): Int

}