package com.sber.quest.mapper

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
            shortText = dto.shortText,
            answer = dto.answer,
            questionType = dto.questionType,
            product = product,
        )
    }

    fun entityToDto(entity: RegularQuestion): RegularQuestionDto {
        return RegularQuestionDto(
            id = entity.id,
            text = entity.text,
            shortText = entity.shortText,
            answer = entity.answer,
            questionType = entity.questionType,
        )
    }
}
