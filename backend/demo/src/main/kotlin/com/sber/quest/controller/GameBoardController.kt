package com.sber.quest.controller

import com.sber.quest.models.dto.questions.GameBoardDto
import com.sber.quest.service.GameBoardService
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RestController

@RestController
@RequestMapping("board")
class GameBoardController(private val gameBoardService: GameBoardService) {
    @PostMapping("/create", produces = ["application/json"])
    fun createBoard(gameBoardDto: GameBoardDto) = gameBoardService.createBoard(gameBoardDto)
}
