package com.sber.quest.mappers

import com.sber.quest.dto.UserDto
import com.sber.quest.models.auth.User

fun UserDto.toEntity() = User(
    username = username,
    password = password!!,
    firstName = firstName,
    middleName = middleName,
    lastName = lastName,
    role = role
)

fun User.toDto() = UserDto(
    id = id,
    username = username,
    password = null,
    firstName = firstName,
    middleName = middleName,
    lastName = lastName,
    role = role,
    status = status
)