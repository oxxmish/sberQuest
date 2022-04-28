package com.sber.quest.mapper

import com.sber.quest.models.dto.GameBoardDto
import com.sber.quest.models.questions.GameBoard
import org.springframework.stereotype.Component

@Component
class GameBoardMapper {
    fun entityToDto(entity: GameBoard): GameBoardDto {
        return GameBoardDto(
            id = entity.id,
            name = entity.name,
            colour = entity.colour,
            regularQuestions = entity.regularQuestions,
            finalQuestions = entity.finalQuestions
        )
    }

    fun dtoToEntity(dto: GameBoardDto): GameBoard {
        return GameBoard(
            id = dto.id,
            name = dto.name,
            colour = dto.colour,
            regularQuestions = dto.regularQuestions,
            finalQuestions = dto.finalQuestions
        )
    }
}
