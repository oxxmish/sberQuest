package com.sber.quest.controller

import com.sber.quest.config.Authorities
import com.sber.quest.dto.UserDto
import com.sber.quest.service.AuthService
import org.springframework.http.MediaType
import org.springframework.security.core.context.SecurityContextHolder
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestBody
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @GetMapping(value = ["/login"], consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun login(): List<String> {
      return SecurityContextHolder.getContext().authentication.authorities.map {it.toString()}
    }

    @PostMapping("/register", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun register(@RequestBody user: UserDto): UserDto {
        return authService.register(user)
    }
}