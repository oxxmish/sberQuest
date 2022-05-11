package com.sber.quest.models.dto

import com.sber.quest.models.questions.QuestionType

data class RegularQuestionDto(
    val id: Long,
    var text: String,
    var answer: String,
    var questionType: QuestionType,
) {
}
