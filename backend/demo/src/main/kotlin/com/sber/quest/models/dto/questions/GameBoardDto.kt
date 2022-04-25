package com.sber.quest.models.dto.questions

import com.sber.quest.models.questions.FinalQuestion
import com.sber.quest.models.questions.RegularQuestion

data class GameBoardDto(
    val id: Long,
    var name: String,
    var colour: String,
    var regularQuestions: List<RegularQuestion>,
    var finalQuestions: List<FinalQuestion>,
) {
}
