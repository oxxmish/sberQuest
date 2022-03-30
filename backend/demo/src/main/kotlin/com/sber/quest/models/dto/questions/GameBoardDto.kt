package com.sber.quest.models.dto.questions

import com.sber.quest.models.questions.FinalQuestion
import com.sber.quest.models.questions.RegularQuestion
import java.util.*

class GameBoardDto(private var name: String,
                   private var colour: String,
                   private var regularQuestions: List<RegularQuestion>,
                   private var finalQuestions: List<FinalQuestion>
) {
    private final val uuid: UUID = UUID.randomUUID()
}
