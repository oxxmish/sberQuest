package com.sber.quest.service

import com.sber.quest.dto.UserDto
import com.sber.quest.mappers.toDto
import com.sber.quest.mappers.toEntity
import com.sber.quest.models.auth.Status
import com.sber.quest.repository.UserRepository
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder
import org.springframework.stereotype.Service

@Service
class AuthService(private val userRepository: UserRepository) {

    val passwordEncoder = BCryptPasswordEncoder(12)
    fun register(user: UserDto): UserDto  {
        var entity = user.toEntity()
        entity.status = Status.WAITING_APPROVE
        entity.password = passwordEncoder.encode(entity.password)
        return userRepository.save(entity).toDto()
    }
}