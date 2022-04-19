package com.sber.quest.controller

import com.sber.quest.models.dto.questions.GameBoardDto
import com.sber.quest.service.GameBoardService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("board")
class GameBoardController(private val gameBoardService: GameBoardService) {
    @PostMapping("/create", produces = ["application/json"])
    fun createBoard(gameBoardDto: GameBoardDto) = gameBoardService.createBoard(gameBoardDto)

    @GetMapping("get/{id}", produces = ["application/json"])
    fun getBoard(@PathVariable id: Long): GameBoardDto {
        return gameBoardService.getGameBoardById(id)
    }
}
