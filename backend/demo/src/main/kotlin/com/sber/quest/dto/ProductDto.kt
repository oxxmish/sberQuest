package com.sber.quest.dto

open class ProductDto(
    var id: Long = 0,
    var name: String,
    var colour: String,
    var questions: List<QuestionDto>
) {
}
