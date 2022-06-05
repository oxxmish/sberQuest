package com.sber.quest.controller

import com.sber.quest.dto.GameBoardRqDto
import com.sber.quest.dto.GameBoardRsDto
import com.sber.quest.dto.ProductDto
import com.sber.quest.models.product.Product
import com.sber.quest.service.GameBoardService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class GameBoardController(private val gameBoardService: GameBoardService) {
    @PostMapping("/create", consumes = [MediaType.APPLICATION_JSON_VALUE], produces = [MediaType.APPLICATION_JSON_VALUE])
    fun createBoard(@RequestBody gameBoardRqDto: GameBoardRqDto)  {
        gameBoardService.createBoard(gameBoardRqDto)
    }

    @PostMapping("/update", consumes = [MediaType.APPLICATION_JSON_VALUE])
    fun updateProduct(@RequestBody gameBoardRqDto: GameBoardRqDto) {
        return gameBoardService.updateBoard(gameBoardRqDto)
    }

    @GetMapping("getAll", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAllBoards(): List<GameBoardRsDto> = gameBoardService.getAllGameBoards()

    @GetMapping("get/{id}", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getBoard(@PathVariable id: Long): GameBoardRsDto = gameBoardService.getGameBoardById(id)

    @DeleteMapping("delete/{id}")
    fun deleteGameBoard(@PathVariable id: Long) {
        gameBoardService.deleteBoard(id)
    }
}
