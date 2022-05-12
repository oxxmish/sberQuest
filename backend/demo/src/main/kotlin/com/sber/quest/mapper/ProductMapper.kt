package com.sber.quest.mapper

import com.sber.quest.models.dto.ProductDto
import com.sber.quest.models.product.Product
import org.springframework.stereotype.Component
import kotlin.streams.toList

@Component
class ProductMapper(private val regularQuestionsMapper: RegularQuestionsMapper) {
    fun dtoToEntity(productDto: ProductDto): Product {
        return Product(
            id = productDto.id,
            name = productDto.name,
            colour = productDto.colour,
        )
    }

    fun entityToDto(product: Product): ProductDto {
        return ProductDto(
            id = product.id,
            name = product.name,
            colour = product.colour,
            questions = product.questions.stream().map{ regularQuestionsMapper.entityToDto(it) }.toList()
        )
    }
}
