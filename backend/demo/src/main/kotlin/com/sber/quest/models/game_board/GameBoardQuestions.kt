package com.sber.quest.models.game_board

import javax.persistence.*

@Entity
@Table(name = "game_boards_questions")
@IdClass(GameBoardQuestionsIdClass::class)
class GameBoardQuestions(
    @Id
    @Column(name = "game_board_id")
    val gameBoardId: Long,
    @Id
    @Column(name = "question_id")
    val questionId: Long,
)
