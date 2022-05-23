package com.sber.quest.repository

import com.sber.quest.models.game_board.GameBoard
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.stereotype.Repository

@Repository
interface GameBoardRepository: JpaRepository<GameBoard, Long> {
}
