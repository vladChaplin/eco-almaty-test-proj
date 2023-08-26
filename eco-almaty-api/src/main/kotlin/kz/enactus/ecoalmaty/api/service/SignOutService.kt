package kz.enactus.ecoalmaty.api.service

import org.springframework.stereotype.Service

@Service
class SignOutService(
    private val sessionService: SessionService,
) {

    fun signOut(token: String): Boolean {
        return sessionService.invalidate(token)
    }

}