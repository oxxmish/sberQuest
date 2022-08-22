package com.sber.quest.service

import com.sber.quest.dto.UserDto
import com.sber.quest.mappers.toDto
import com.sber.quest.mappers.toEntity
import com.sber.quest.repository.UserRepository
import org.springframework.stereotype.Service

@Service
class AuthService(private val userRepository: UserRepository) {
    fun register(user: UserDto): UserDto  {
        return userRepository.save(user.toEntity()).toDto()
    }
}