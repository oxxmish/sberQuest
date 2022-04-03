package com.sber.quest.controller

import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.RequestMapping
import org.springframework.web.bind.annotation.RequestParam

@Controller
@RequestMapping("game")
class GameController {
    @GetMapping
    fun chooseQuestion(@RequestParam questionId: Long) {

    }
}
