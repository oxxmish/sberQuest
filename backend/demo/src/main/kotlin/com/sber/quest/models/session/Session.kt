package com.sber.quest.models.session

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "sessions")
data class Session(
    @Id
    @Column(name = "uuid", unique = true)
    val uuid: UUID,
    @Column(name = "username")
    val userName: String,
    @Column(name = "current_answer")
    var currentAnswer: String,
    @Column(name = "state")
    var state: String
) {
}
