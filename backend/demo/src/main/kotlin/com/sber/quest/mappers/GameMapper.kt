package com.sber.quest.mappers

import com.sber.quest.dto.GameDto
import com.sber.quest.models.auth.User
import com.sber.quest.models.game.GameEntity

fun GameDto.toEntity(leaders: MutableList<User>) = GameEntity(
    id = this.id,
    gameState = this.gameState,
    name = this.name,
    time = this.time,
    welcomeMessage = this.welcomeMessage,
    leaders = leaders
)

fun GameEntity.toDto() = GameDto(
    id = this.id,
    gameState = this.gameState,
    name = this.name,
    time = this.time,
    welcomeMessage = this.welcomeMessage,
    leaderIds = this.leaders.map { it.id }
)
