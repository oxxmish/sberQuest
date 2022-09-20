package com.sber.quest.controller

import com.sber.quest.dto.AnswerAndStateDto
import com.sber.quest.dto.GameDto
import com.sber.quest.models.game.GameEntity
import com.sber.quest.models.questions.ChooseQuestionRequest
import com.sber.quest.service.GameService
import org.springframework.http.MediaType
import org.springframework.web.bind.annotation.*

@RestController
@RequestMapping("game")
class GameController(val gameService: GameService) {

    @PostMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun create(@RequestBody rq: GameDto): GameDto =
        gameService.create(rq)

    @PutMapping(
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun update(@RequestBody rq: GameDto): GameDto =
        gameService.update(rq)

    @GetMapping(
        "/{id}",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun get(@PathVariable(name = "id") id: Long): GameDto =
        gameService.get(id)

    @GetMapping(
        "/getAll",
        consumes = [MediaType.APPLICATION_JSON_VALUE],
        produces = [MediaType.APPLICATION_JSON_VALUE]
    )
    fun getAll(): MutableList<GameEntity> =
        gameService.getAll()

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
