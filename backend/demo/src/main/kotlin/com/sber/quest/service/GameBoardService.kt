package com.sber.quest.service

import com.sber.quest.dto.GameBoardRqDto
import com.sber.quest.dto.GameBoardRsDto
import com.sber.quest.dto.ProductForBoardRqDto
import com.sber.quest.mappers.*
import com.sber.quest.models.game_board.GameBoardQuestions
import com.sber.quest.models.game_board.ProductsForGameBoards
import com.sber.quest.repository.*
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.transaction.Transactional

@Service
class GameBoardService(
    private val gameBoardRepository: GameBoardRepository,
    private val productsForGameRepo: ProductsForGameBoardRepository,
    private val gameBoardQuestionsRepo: GameBoardQuestionsRepository,
    private val productRepo: ProductRepository,
    private val questionsRepo: QuestionRepository,
) {
    @Transactional
    fun createBoard(gameBoardRqDto: GameBoardRqDto) {
        val gameBoard = gameBoardRepository.save(gameBoardRqDto.toInitialEnt())
        val products = gameBoardRqDto.productWithQuestionRqs.map {
            ProductsForGameBoards(
                gameBoardId = gameBoard.id,
                productId = it.productId,
                numOfRepeating = it.numberOfRepeating
            )
        }
        productsForGameRepo.saveAll(products)
        val questions = gameBoardRqDto.productWithQuestionRqs
            .map(ProductForBoardRqDto::questionIds)
            .flatten()
            .map { GameBoardQuestions(gameBoardId = gameBoard.id, questionId = it) }
        gameBoardQuestionsRepo.saveAll(questions)
    }

    @Transactional
    fun updateBoard(gameBoardRqDto: GameBoardRqDto) {
        if (gameBoardRepository.findById(gameBoardRqDto.id).isPresent) {
            val gameBoard = gameBoardRepository.save(gameBoardRqDto.toInitialEnt())
            val products = gameBoardRqDto.productWithQuestionRqs.map {
                ProductsForGameBoards(
                    gameBoardId = gameBoard.id,
                    productId = it.productId,
                    numOfRepeating = it.numberOfRepeating
                )
            }
            productsForGameRepo.saveAll(products)
            gameBoardQuestionsRepo.deleteGameBoardQuestionsByGameBoardId(gameBoard.id)
            val questions = gameBoardRqDto.productWithQuestionRqs
                .map(ProductForBoardRqDto::questionIds)
                .flatten()
                .map { GameBoardQuestions(gameBoardId = gameBoard.id, questionId = it) }
            gameBoardQuestionsRepo.saveAll(questions)
        } else {
            throw RuntimeException("Не найден редактируемый продукт")
        }
    }

    fun getGameBoardById(id: Long): GameBoardRsDto {
        val gameBoard = gameBoardRepository.getById(id)
        val questionIds = gameBoardQuestionsRepo.findAllByGameBoardId(id)
        val questions = questionsRepo.findAllByIdOrderById(questionIds)
        // групируем все вопросы по продукту
        // получаем мапу Product -> List<QuestionDto>
        // пробугаемся по мапе и делаем из нее List<ProductDto>, но с вопросами из начальной коллекции
        val productsDto = questions.groupBy(
            keySelector = { it.product },
            valueTransform = { it.toDto() })
            .entries
            .map { it.key.toDtoWithQuestions(it.value) }
        val productsForGameBoards = productsForGameRepo.findAllByGameBoardId(id)
        val products = productsDto.map { it.toDtoForGameBoard(productsForGameBoards.findNumByProductId(it.id)) }
        return gameBoard.toDto(products)
    }

    fun getAllGameBoards(): List<GameBoardRsDto> {
        return gameBoardRepository.findAllByOrderById().map { it.toDto() }
    }

    private fun List<ProductsForGameBoards>.findNumByProductId(productId: Long) =
        this.findLast { it.productId == productId }!!.numOfRepeating
}
