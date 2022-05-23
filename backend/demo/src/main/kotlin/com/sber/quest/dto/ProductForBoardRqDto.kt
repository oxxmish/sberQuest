package com.sber.quest.dto

data class ProductForBoardRqDto(val productId: Long,
                                val numberOfRepeating: Int,
                                val questionIds: List<Long>) {
}
