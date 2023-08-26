package kz.enactus.ecoalmaty.api.config

import kz.enactus.ecoalmaty.api.interceptor.auth.AuthInterceptor
import kz.enactus.ecoalmaty.api.repository.RoleRepository
import kz.enactus.ecoalmaty.api.repository.UserRepository
import kz.enactus.ecoalmaty.api.service.SessionService
import org.springframework.context.annotation.Configuration
import org.springframework.web.servlet.config.annotation.InterceptorRegistry
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer

@Configuration
class InterceptorConfig(
    private val sessionService: SessionService,
    private val userRepository: UserRepository,
    private val roleRepository: RoleRepository,
) : WebMvcConfigurer {

    override fun addInterceptors(registry: InterceptorRegistry) {
        registry.addInterceptor(AuthInterceptor(sessionService, userRepository, roleRepository))
            .order(1)
            .excludePathPatterns("/sign-up/**", "/sign-in", "/**/public/**")
            .excludePathPatterns("/api/v1/version")
            .excludePathPatterns("/swagger-ui.html", "/swagger-resources/**", "/v2/api-docs")
    }

}