package com.sber.quest.controller

import com.sber.quest.service.GameService
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game")
class GameController(val gameService: GameService) {
    @PostMapping("/chooseQuestion", consumes = ["application/json"], produces = ["application/json"])
    fun chooseQuestion(@RequestBody request: ChooseQuestionRequest) {
        gameService.onChooseQuestion(request.questionId, request.questionType)
    }

    @GetMapping("/getAnswer", produces = ["application/json"])
    fun getAnswer(): String {
        return gameService.getAnswerFromActiveSession()
    }
}
