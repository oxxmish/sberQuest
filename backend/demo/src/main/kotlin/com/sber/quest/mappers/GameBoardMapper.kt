package com.sber.quest.mappers

import com.sber.quest.dto.GameBoardRqDto
import com.sber.quest.dto.GameBoardRsDto
import com.sber.quest.dto.ProductForBoardRsDto
import com.sber.quest.models.game_board.GameBoard
import com.sber.quest.models.product.Product
import com.sber.quest.models.questions.Question

fun GameBoardRqDto.toInitialEnt() = GameBoard(id = this.id, name = this.name, numFields = this.numFields)
fun GameBoard.toDto(products: List<ProductForBoardRsDto>? = null) =
    GameBoardRsDto(id = this.id, name = this.name, numFields = this.numFields, products = products)
