package com.sber.quest.repository

import com.sber.quest.models.game.GameEntity
import org.springframework.data.jpa.repository.JpaRepository

interface GameEntityRepository : JpaRepository<GameEntity, Long> {
}