package com.sber.quest.controller

import com.sber.quest.dto.AnswerAndStateDto
import com.sber.quest.models.questions.ChooseQuestionRequest
import com.sber.quest.service.GameService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game")
class GameController(val gameService: GameService) {
    @PostMapping(
        "/chooseQuestion",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun chooseQuestion(@RequestBody rq: ChooseQuestionRequest) {
        gameService.onChooseQuestion(rq.questionId, rq.questionType, rq.state)
    }

    @GetMapping("/getAnswer", produces = [MediaType.APPLICATION_JSON_VALUE])
    fun getAnswer(): AnswerAndStateDto {
        return gameService.getAnswerAndStateFromActiveSession()
    }
}
