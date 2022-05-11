package com.sber.quest.service

import com.sber.quest.mapper.ProductMapper
import com.sber.quest.mapper.RegularQuestionsMapper
import com.sber.quest.models.dto.ProductDto
import com.sber.quest.models.product.Product
import com.sber.quest.repository.ProductRepository
import com.sber.quest.repository.RegularQuestionRepository
import org.springframework.stereotype.Service
import java.lang.RuntimeException

@Service
class ProductService(
    private val productRepository: ProductRepository,
    private val productMapper: ProductMapper,
    private val questionMapper: RegularQuestionsMapper,
    private val regularQuestionRepository: RegularQuestionRepository
) {
    fun createProduct(productDto: ProductDto): Product {
        val product = productRepository.save(productMapper.dtoToEntity(productDto))
        val questions = productDto.questions.map { questionMapper.dtoToEntity(it, product) }
        regularQuestionRepository.saveAll(questions)
        return product
    }

    fun updateProduct(productDto: ProductDto): Product {
        if (productRepository.findById(productDto.id).isPresent) {
            return this.createProduct(productDto)
        } else {
            throw RuntimeException("Не найден редактируемый продукт")
        }
    }

    fun getCurrentProducts(): MutableList<Product> {
        return productRepository.findAll()
    }
}
