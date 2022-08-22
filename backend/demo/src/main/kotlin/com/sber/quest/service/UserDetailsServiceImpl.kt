package com.sber.quest.service

import com.sber.quest.models.auth.SecurityUser
import com.sber.quest.repository.UserRepository
import org.springframework.security.core.userdetails.UserDetails
import org.springframework.security.core.userdetails.UserDetailsService
import org.springframework.stereotype.Service

@Service
class UserDetailsServiceImpl(private val userRepository: UserRepository): UserDetailsService {
    override fun loadUserByUsername(username: String?): UserDetails {
        val user = userRepository.findByUsername(username!!)
        return SecurityUser.fromUser(user)
    }
}