package com.sber.quest.dto

import com.sber.quest.config.Authorities
import com.sber.quest.models.auth.Status

data class UserDto(
    val id: Long = 0,
    val username: String,
    val password: String?,
    val firstName: String,
    val middleName: String,
    val lastName: String,
    val status: Status?,
    val role: Authorities,
)
