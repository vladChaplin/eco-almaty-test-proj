package kz.enactus.ecoalmaty.api.interceptor.auth

import jakarta.servlet.http.HttpServletRequest
import jakarta.servlet.http.HttpServletResponse
import kz.enactus.ecoalmaty.api.repository.RoleRepository
import kz.enactus.ecoalmaty.api.repository.UserRepository
import kz.enactus.ecoalmaty.api.service.SessionService
import kz.enactus.ecobox.api.exception.SessionHasExpiredException
import kz.enactus.ecobox.api.exception.UserNotFoundException
import org.springframework.web.servlet.HandlerInterceptor
import java.time.LocalDateTime

class AuthInterceptor(
    private val sessionService: SessionService,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
) : HandlerInterceptor {

    override fun preHandle(request: HttpServletRequest, response: HttpServletResponse, handler: Any): Boolean {
        val authToken = request.getHeader("Auth-Token")

        val session = sessionService.findByToken(authToken)
        if (LocalDateTime.now().isAfter(session.expiresAt)) {
            sessionService.invalidate(session.token!!)
            throw SessionHasExpiredException()
        }

        val user = userRepository.findById(session.userId!!).orElseThrow { UserNotFoundException() }
        val roles = roleRepository.getAllForUserId(user.id!!)

        request.setAttribute("user", user)
        request.setAttribute("roles", roles)

        return true
    }

}
