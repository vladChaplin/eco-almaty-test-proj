package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.request.SignUpRequest
import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.model.response.SignUpResponse
import kz.enactus.ecoalmaty.api.service.SignUpService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-up")
class SignUpController(
    private val signUpService: SignUpService,
) {

    @PostMapping
    fun signUpIndividual(@RequestBody request: SignUpRequest): MessagedResponse<SignUpResponse> {
        return signUpService.signUp(request).let(MessagedResponse.Companion::ofBody)
    }

}