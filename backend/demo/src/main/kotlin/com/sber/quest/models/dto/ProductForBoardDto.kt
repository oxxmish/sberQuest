package com.sber.quest.models.dto

data class ProductForBoardDto(val productId: Int,
                              val numberOfRepeating: Int,
                              val questionIds: List<Int>) {
}
