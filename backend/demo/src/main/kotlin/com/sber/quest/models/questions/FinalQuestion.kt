package com.sber.quest.models.questions

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "final_questions")
class FinalQuestion(
    @Id
    val id: Long,
    @Column(name = "text")
    var text: String,
    @Column(name = "answer")
    var answer: String,
    @ManyToOne
//    @JoinColumn(
//        name = "question_id",
//        referencedColumnName = "uuid",
//        nullable = false
//    )
    var gameBoard: GameBoard,
) {
}
