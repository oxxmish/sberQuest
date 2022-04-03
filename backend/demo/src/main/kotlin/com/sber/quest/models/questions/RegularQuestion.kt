package com.sber.quest.models.questions

import javax.persistence.*

@Entity
@Table(name = "regular_questions")
data class RegularQuestion(
    @Id
    val id: Long,
    @Column(name = "text", length = 2000)
    var text: String,
    @Column(name = "answer", length = 500)
    var answer: String,
    @Column(name = "type")
    @Enumerated(value = EnumType.STRING)
    var questionType: QuestionType,
    @ManyToOne
    var gameBoard: GameBoard
) {
}
