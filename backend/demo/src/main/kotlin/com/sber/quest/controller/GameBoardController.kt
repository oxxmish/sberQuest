package com.sber.quest.controller

import com.sber.quest.dto.GameBoardRqDto
import com.sber.quest.dto.GameBoardRsDto
import com.sber.quest.service.GameBoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class GameBoardController(private val gameBoardService: GameBoardService) {
    @PostMapping("/create", consumes = ["application/json"], produces = ["application/json"])
    fun createBoard(@RequestBody gameBoardRqDto: GameBoardRqDto)  {
        gameBoardService.createBoard(gameBoardRqDto)
    }

    @GetMapping("getAll", produces = ["application/json"])
    fun getAllBoards(): List<GameBoardRsDto> = gameBoardService.getAllGameBoards()

    @GetMapping("get/{id}", produces = ["application/json"])
    fun getBoard(@PathVariable id: Long): GameBoardRsDto = gameBoardService.getGameBoardById(id)
}
