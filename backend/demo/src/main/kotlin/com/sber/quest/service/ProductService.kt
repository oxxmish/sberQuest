package com.sber.quest.service

import com.sber.quest.mappers.toDto
import com.sber.quest.mappers.toEntity
import com.sber.quest.dto.ProductDto
import com.sber.quest.models.product.Product
import com.sber.quest.repository.GameBoardQuestionsRepository
import com.sber.quest.repository.ProductRepository
import com.sber.quest.repository.QuestionRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException
import javax.transaction.Transactional

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val questionRepository: QuestionRepository,
    private val gameBoardQuestionsRepository: GameBoardQuestionsRepository
) {
    fun createProduct(productDto: ProductDto): Product {
        val product = productRepository.save(productDto.toEntity())
        // Перерписать с addQuestions
        val questions = productDto.questions.map { it.toEntity(product) }
        questionRepository.saveAll(questions)
        return product
    }

    fun updateProduct(productDto: ProductDto): Product {
        if (productRepository.findById(productDto.id).isPresent) {
            val product = productRepository.save(productDto.toEntity())
            val dtoQuestions = productDto.questions.map { it.toEntity(product) }
            val questions = product.questions.plus(dtoQuestions)
            questions.apply { questionRepository.saveAll(questions) }
            return product
        } else {
            throw RuntimeException("Не найден редактируемый продукт")
        }
    }

    fun getCurrentProducts(): List<ProductDto> {
        return productRepository.findAllByOrderById().map { it.toDto() }
    }

    @Transactional
    fun deleteQuestion(id: Long) {
        //TODO удалить этот ужасный костыль
        gameBoardQuestionsRepository.deleteGameBoardQuestionsByQuestionId(id)
        questionRepository.deleteById(id)
    }
}
