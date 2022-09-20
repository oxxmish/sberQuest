package com.sber.quest.models.game

import com.sber.quest.models.auth.User
import java.time.LocalDateTime
import javax.persistence.*

@Entity
@Table(name = "game_entity")
class GameEntity (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "game_entity_id_seq")
    @SequenceGenerator(name = "game_entity_id_seq", sequenceName="game_entity_id_seq", allocationSize=1)
    @Column(name = "id", nullable = false)
    val id: Long = 0,
    @Column(name = "game_state")
    var gameState: String = "",
    @Column(name = "name")
    var name: String = "",
    @Column(name = "date")
    var time: LocalDateTime,
    @Column(name = "welcome_message")
    var welcomeMessage: String,
    @OneToMany(fetch = FetchType.EAGER, orphanRemoval = true)
    var leaders: MutableList<User>
)