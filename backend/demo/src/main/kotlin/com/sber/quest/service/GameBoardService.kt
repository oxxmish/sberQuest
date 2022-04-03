package com.sber.quest.service

import com.sber.quest.mapper.GameBoardMapper
import com.sber.quest.models.dto.questions.GameBoardDto
import com.sber.quest.repository.GameBoardRepository
import org.springframework.stereotype.Service

@Service
class GameBoardService(
    private val gameBoardRepository: GameBoardRepository,
    private val gameBoardMapper: GameBoardMapper
) {
    fun createBoard(gameBoardDto: GameBoardDto) {
        val entity = gameBoardMapper.dtoToEntity(gameBoardDto)
        gameBoardRepository.save(entity)
    }

    fun getGameBoardById(id: Long): GameBoardDto {
        return gameBoardMapper.entityToDto(gameBoardRepository.getById(id))
    }
}
