package com.sber.quest.mapper

import com.sber.quest.models.dto.ProductDto
import com.sber.quest.models.product.Product
import org.springframework.stereotype.Component

@Component
class ProductMapper {
    fun dtoToEntity(productDto: ProductDto): Product {
        return Product(
            id = productDto.id,
            name = productDto.name,
            colour = productDto.colour,
        )
    }
}
