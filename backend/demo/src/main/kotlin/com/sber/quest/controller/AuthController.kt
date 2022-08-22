package com.sber.quest.controller

import com.sber.quest.dto.UserDto
import com.sber.quest.service.AuthService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("/auth")
class AuthController(private val authService: AuthService) {

    @PostMapping("/register")
    fun register(user: UserDto): UserDto {
        return authService.register(user)
    }
}