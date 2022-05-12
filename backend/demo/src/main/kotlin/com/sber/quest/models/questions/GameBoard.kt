package com.sber.quest.models.questions

import com.sber.quest.models.product.ProductsForBoard
import javax.persistence.*

@Entity
@Table(name = "game_board")
data class GameBoard (
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator="game_board_id_seq")
    @SequenceGenerator(name="game_board_id_seq", sequenceName="game_board_id_seq", allocationSize=1)
    val id: Long = 0,
    @Column(name = "name")
    val name: String,
    @Column(name = "num_fields")
    val numFields: Int,
    @OneToOne
    val productsForBoard: ProductsForBoard,
    @OneToMany
    @JoinColumn(name = "final_questions")
    val finalQuestions: List<FinalQuestion>
) {
}
