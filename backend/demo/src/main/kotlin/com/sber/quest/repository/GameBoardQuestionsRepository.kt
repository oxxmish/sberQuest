package com.sber.quest.repository

import com.sber.quest.models.game_board.GameBoardQuestions
import org.springframework.data.jpa.repository.JpaRepository
import org.springframework.data.jpa.repository.Query
import org.springframework.data.repository.query.Param
import org.springframework.stereotype.Repository

@Repository
interface GameBoardQuestionsRepository: JpaRepository<GameBoardQuestions, Long> {
    @Query("select g.questionId" +
            " from GameBoardQuestions g" +
            " where g.gameBoardId = :id")
    fun findAllByGameBoardId(@Param("id") id: Long): List<Long>
}
