package com.sber.quest.models.questions

class RegularQuestion(private var answer: String,
                      private var questionType: QuestionType
) : Question(answer) {
}
