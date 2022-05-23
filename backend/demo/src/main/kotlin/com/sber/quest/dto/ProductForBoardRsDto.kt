package com.sber.quest.dto

class ProductForBoardRsDto(
    id: Long,
    name: String,
    colour: String,
    questions: List<QuestionDto>,
    val numOfRepeating: Int,
) : ProductDto(id = id, name = name, colour = colour, questions = questions)
