package com.sber.quest.models.questions

import java.util.*
import javax.persistence.*

@Entity
@Table(name = "game_board")
data class GameBoard (
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    val id: Long = 0,
    @Column(name = "name")
    var name: String,
    @Column(name = "colour")
    var colour: String,
    @OneToMany(mappedBy = "gameBoard")
    var regularQuestions: List<RegularQuestion>,
    @OneToMany(mappedBy = "gameBoard")
    var finalQuestions: List<FinalQuestion>,
) {
}
