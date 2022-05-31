package com.sber.quest.mappers

import com.sber.quest.dto.ProductDto
import com.sber.quest.dto.ProductForBoardRsDto
import com.sber.quest.dto.QuestionDto
import com.sber.quest.models.product.Product

fun ProductDto.toEntity() = Product(
    id = this.id,
    name = this.name,
    colour = this.colour,
)

fun ProductDto.toDtoForGameBoard(numOfRepeating: Int) = ProductForBoardRsDto(
    id = this.id,
    name = this.name,
    colour = this.colour,
    questions = this.questions,
    numOfRepeating = numOfRepeating,
)

fun Product.toDto() = ProductDto(
    id = this.id,
    name = this.name,
    colour = this.colour,
    questions = this.questions?.map { it.toDto() } ?: emptyList()
)

fun Product.toDtoWithQuestions(questions: List<QuestionDto>) =
    ProductDto(
        id = this.id,
        name = this.name,
        colour = this.colour,
        questions = questions
    )
