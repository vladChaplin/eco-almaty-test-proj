package kz.enactus.ecoalmaty.api.controller

import kz.enactus.ecoalmaty.api.model.response.MessagedResponse
import kz.enactus.ecoalmaty.api.service.SignOutService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/sign-out")
class SignOutController(
    private val signOutService: SignOutService,
) {

    @PostMapping
    fun signOut(@RequestParam(required = true) token: String): MessagedResponse<Boolean> {
        return signOutService.signOut(token).let(MessagedResponse.Companion::of)
    }

}