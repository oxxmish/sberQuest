package com.sber.quest.models.dto

class ProductDto(
    var id: Long = 0,
    var name: String,
    var colour: String,
    var questions: List<RegularQuestionDto>
) {
}
