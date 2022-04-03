package com.sber.quest.repository

import com.sber.quest.models.questions.GameBoard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository
import java.util.*

@Repository
interface GameBoardRepository: JpaRepository<GameBoard, Long> {
}
