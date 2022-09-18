package com.sber.quest.mappers

import com.sber.quest.dto.QuestionDto
import com.sber.quest.models.product.Product
import com.sber.quest.models.questions.Question
import org.apache.logging.log4j.util.Strings
import java.time.LocalDateTime

fun QuestionDto.toEntity(product: Product) = Question(
    id = this.id,
    text = this.text,
    shortText = this.shortText ?: Strings.EMPTY,
    answer = this.answer,
    questionType = this.questionType,
    product = product,
    lastUpdate = LocalDateTime.now()
)

fun Question.toDto() = QuestionDto(
    id = this.id,
    text = this.text,
    shortText = this.shortText,
    answer = this.answer,
    questionType = this.questionType,
    lastUpdate = this.lastUpdate
)
