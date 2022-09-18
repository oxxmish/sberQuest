package com.sber.quest.dto

import com.sber.quest.models.questions.QuestionType
import java.time.LocalDateTime

data class QuestionDto(
    val id: Long,
    var text: String,
    var shortText: String?,
    var answer: String,
    var lastUpdate: LocalDateTime,
    var questionType: QuestionType,
)
