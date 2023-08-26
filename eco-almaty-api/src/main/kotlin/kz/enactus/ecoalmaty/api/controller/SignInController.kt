package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.entity.Session
import kz.enactus.ecoalmaty.api.model.request.SignInRequest
import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.service.SignInService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-in")
class SignInController(
    private val signInService: SignInService,
) {

    @PostMapping
    fun signIn(@RequestBody signInRequest: SignInRequest): MessagedResponse<Session> {
        return signInService.findByEmail(signInRequest).let(MessagedResponse.Companion::of)
    }

}