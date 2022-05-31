package com.sber.quest.dto

import com.sber.quest.models.questions.QuestionType

data class QuestionDto(
    val id: Long,
    var text: String,
    var shortText: String?,
    var answer: String,
    var questionType: QuestionType,
) {
}
