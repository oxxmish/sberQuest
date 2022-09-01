package com.sber.quest.controller

import com.sber.quest.dto.ProductDto
import com.sber.quest.models.product.Product
import com.sber.quest.service.ProductService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("product")
class ProductController(private val productService: ProductService) {
    @PostMapping("/create")
    fun createProduct(@RequestBody productDto: ProductDto): Product {
        return productService.createProduct(productDto)
    }

    @PostMapping("/update")
    fun updateProduct(@RequestBody productDto: ProductDto): Product {
        return productService.updateProduct(productDto)
    }

    @GetMapping("/getAll")
    fun getAllProducts(): List<ProductDto> {
        return productService.getCurrentProducts()
    }

    @DeleteMapping("/question/{questionId}")
    fun deleteQuestionInProduct(@PathVariable questionId: Long) {
        return productService.deleteQuestion(questionId)
    }
}
