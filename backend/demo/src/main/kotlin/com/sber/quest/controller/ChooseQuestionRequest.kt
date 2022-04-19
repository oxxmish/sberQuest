package com.sber.quest.controller

import com.sber.quest.models.session.QuestionType

data class ChooseQuestionRequest(val questionId: Long,
                                 val questionType: QuestionType) {
}
