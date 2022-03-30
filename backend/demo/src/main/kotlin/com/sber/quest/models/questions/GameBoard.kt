package com.sber.quest.models.questions

import java.util.*
import javax.persistence.Entity
import javax.persistence.Id

@Entity
class GameBoard(private var name: String,
                private var colour: String,
                private var regularQuestions: List<RegularQuestion>,
                private var finalQuestions: List<FinalQuestion>
) {
    @Id
    private final val uuid: UUID = UUID.randomUUID()
}
