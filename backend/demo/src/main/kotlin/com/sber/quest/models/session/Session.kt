package com.sber.quest.models.session

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "sessions")
data class Session(
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val uuid: UUID,
    @Column(name = "username")
    val userName: String,
    @Column(name = "current_answer")
    var currentAnswer: String
) {
}
