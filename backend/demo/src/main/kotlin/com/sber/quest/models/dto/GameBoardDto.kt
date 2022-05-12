package com.sber.quest.models.dto

data class GameBoardDto(
    val id: Long,
    val name: String,
    val productWithQuestionsDto: ProductForBoardDto,
    val finalQuestions: FinalQuestionsDto,
    val numFields: Int,
) {
}
