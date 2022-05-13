package com.sber.quest.models.questions

import javax.persistence.*

@Entity
@Table(name = "game_board")
data class GameBoard (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="game_board_id_seq")
    @SequenceGenerator(name="game_board_id_seq", sequenceName="game_board_id_seq", allocationSize=1)
    val id: Long = 0,
    @Column(name = "name")
    var name: String,
    @Column(name = "colour")
    var colour: String,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "game_board_id")
    var regularQuestions: List<RegularQuestion>,
    @OneToMany(cascade = [CascadeType.ALL], orphanRemoval = true)
    @JoinColumn(name = "game_board_id")
    var finalQuestions: List<FinalQuestion>,
) {
}
