package com.sber.quest.dto

data class GameBoardRqDto(
    var id: Long = 0,
    val name: String,
    val productWithQuestionRqs: List<ProductForBoardRqDto>,
    val numFields: Int,
)
