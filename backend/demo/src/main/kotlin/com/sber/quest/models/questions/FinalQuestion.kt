package com.sber.quest.models.questions

import javax.persistence.*

@Entity
@Table(name = "final_questions")
data class FinalQuestion(
    @Id
    val id: Long,
    @Column(name = "text")
    var text: String,
    @Column(name = "answer")
    var answer: String,
) {
}
