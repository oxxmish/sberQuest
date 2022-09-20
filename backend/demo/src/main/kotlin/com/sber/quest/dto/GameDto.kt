package com.sber.quest.dto

import java.io.Serializable
import java.time.LocalDateTime

data class GameDto(
    var id: Long = 0,
    var gameState: String,
    var name: String,
    var time: LocalDateTime,
    var welcomeMessage: String,
    var leaderIds: List<Long>?
) : Serializable
