package com.sber.quest.mapper

import com.sber.quest.models.dto.ProductDto
import com.sber.quest.models.dto.RegularQuestionDto
import com.sber.quest.models.product.Product
import com.sber.quest.models.questions.RegularQuestion
import org.springframework.stereotype.Component

@Component
class RegularQuestionsMapper {
    fun dtoToEntity(dto: RegularQuestionDto, product: Product): RegularQuestion {
        return RegularQuestion(
            id = dto.id,
            text = dto.text,
            answer = dto.answer,
            questionType = dto.questionType,
            product = product,
        )
    }
}
