package com.sber.quest.dto

import com.fasterxml.jackson.annotation.JsonInclude

@JsonInclude(JsonInclude.Include.NON_NULL)
data class GameBoardRsDto(
    val id: Long = 0,
    val name: String,
    val products: List<ProductForBoardRsDto>? = null,
    val numFields: Int,
)
